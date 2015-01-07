package com.norming.rpc.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.norming.rpc.AbstractRpcFactory;
import com.norming.rpc.rmi.RmiClientUtil;

public class RpcRmiFactory extends AbstractRpcFactory {
	
	private static final Log LOG = LogFactory.getLog(RpcRmiFactory.class);


	@Override
	public <T> InvocationHandler getInvocationHandler(final Class<T> clazz) {
		return new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, final Method method, final Object[] args)
					throws Throwable {
				
				if (method.getReturnType() == Void.class) {
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
			
			
			private Object doWork(final Method method, final Object[] args) throws Throwable {
				List<T> list = RmiClientUtil.getRemoteObjects(clazz.getSimpleName());
				
				Object ret = null;
				for (final T target : list) {
					ret = method.invoke(target, args);
				}
				return ret;
			}
		};
	}
}
