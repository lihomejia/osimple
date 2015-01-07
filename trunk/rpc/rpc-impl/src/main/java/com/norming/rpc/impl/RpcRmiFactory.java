package com.norming.rpc.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.norming.rpc.AbstractRpcFactory;
import com.norming.rpc.rmi.RmiClientUtil;

/**
 * 
 * @author lh.jia
 * Created on Jan 7, 2015 
 *
 */
public class RpcRmiFactory extends AbstractRpcFactory {
	
	private static final Log LOG = LogFactory.getLog(RpcRmiFactory.class);


	@Override
	public <T> InvocationHandler getInvocationHandler(final Class<T> clazz) {
		return new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, final Method method, final Object[] args)
					throws Throwable {
				
				if (method.getReturnType() == Void.TYPE) {
					new Thread() {
						public void run() {
							try {
								doWork(method, args);
							} catch (Throwable e) {
								LOG.error(e.getLocalizedMessage());
								e.printStackTrace();
							}
						}
					}.start();
					
					return null;
				}
				return doWork(method, args);
			}
			
			
			/**
			 * Call real remote objects method. 
			 * Created on Jan 7, 2015 
			 * @param method
			 * @param args
			 * @return
			 * @throws Throwable
			 */
			private Object doWork(final Method method, final Object[] args) throws Throwable {
				List<T> list = RmiClientUtil.getRemoteObjects(getRemoteName());
				
				Object ret = null;
				for (final T target : list) {
					ret = method.invoke(target, args);
				}
				return ret;
			}
			
			
			/**
			 * Get Remote Name.
			 * Created on Jan 7, 2015 
			 * @return
			 */
			private String getRemoteName() {
				String remoteName = null;
				try {
					Field filed = clazz.getField("BEAN_NAME");
					
					remoteName = (String) filed.get(clazz);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (remoteName == null) {
					remoteName = clazz.getSimpleName();
				}
				
				return remoteName;
			}
		};
	}
}