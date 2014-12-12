package com.norming.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 
 * @author lh.jia
 * Created on Dec 12, 2014 
 *
 */
public abstract class AbstractRpcFactory implements IRpcHolder {

	private static Map<Class<?>, InvocationHandler> mHandler = new ConcurrentHashMap<>();
	
	
	
	/*
	 * (non-Javadoc)
	 * @see com.norming.rpc.IRpcHolder#getRpcBean(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getRpcBean(Class<T> clazz) {
		
		InvocationHandler handler = mHandler.get(clazz);
		
		if (handler == null) {
			handler = this.getInvocationHandler(clazz);
			
			mHandler.put(clazz, handler);
		}
		
		
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
				new Class[] { clazz }, handler);
	}
	

	
	/**
	 * 
	 * Created on Dec 12, 2014 
	 * @param clazz
	 * @return
	 */
	public abstract <T> InvocationHandler getInvocationHandler(Class<T> clazz);

}
