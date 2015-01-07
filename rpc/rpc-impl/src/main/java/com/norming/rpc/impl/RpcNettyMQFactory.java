package com.norming.rpc.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.norming.rpc.AbstractRpcFactory;

public class RpcNettyMQFactory extends AbstractRpcFactory {
	
	private static final Log LOG = LogFactory.getLog(RpcNettyMQFactory.class);

	
	@Override
	public <T> InvocationHandler getInvocationHandler(final Class<T> clazz) {
		
		final Object target = this.findTarget(clazz);
		
		return new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				LOG.info("...");
				
				return method.invoke(target, args);
			}
		};
	}

	
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	private Object findTarget(Class<?> clazz) {

		//TODO
		return null;
		
	}
	
}
