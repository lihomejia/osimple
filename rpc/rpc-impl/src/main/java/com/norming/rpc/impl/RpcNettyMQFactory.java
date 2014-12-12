package com.norming.rpc.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.norming.rpc.AbstractRpcFactory;

public class RpcNettyMQFactory extends AbstractRpcFactory {
	
	private static final Log LOG = LogFactory.getLog(RpcNettyMQFactory.class);


	
	@Override
	public <T> InvocationHandler getInvocationHandler(final Class<T> clazz) {
		
		final T target = this.findTarget(clazz);
		
		return new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				LOG.info("invoke method:" + method.getName() + ", args:" + Arrays.asList(args));
				
				return method.invoke(target, args);
			}
		};
	}

	
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	private <T> T findTarget(Class<T> clazz) {

		//TODO
		
		return null;
		
	}
	
}
