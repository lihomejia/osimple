package com.norming.rpc;


/**
 * 
 * @author lh.jia
 * Created on Dec 12, 2014 
 *
 */
public interface IRpcContext {
	
	
	/**
	 * Return an instance, which of the specified class.
	 * @param clazz
	 * @return
	 */
	<T> T getRpcBean(Class<T> clazz);
	
}
