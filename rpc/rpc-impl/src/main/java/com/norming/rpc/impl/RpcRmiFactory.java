package com.norming.rpc.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
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
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				LOG.info("invoke method:" + method.getName() + ", args:" + Arrays.asList(args));
				
				
				List<T> list = RmiClientUtil.getRemoteObjects(clazz.getSimpleName());
				
				Object ret = null;
				for (T target : list) {
					
					ret = method.invoke(target, args);
				}
				
				return ret;
			}
		};
	}
}
