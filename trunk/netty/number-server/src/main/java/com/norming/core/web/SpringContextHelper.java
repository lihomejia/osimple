package com.norming.core.web;

import org.springframework.context.ApplicationContext;

public class SpringContextHelper {
	
	static ApplicationContext context;
	
	public static ApplicationContext getContext(){
		return context;
	}
	
	public static void setContext(ApplicationContext context) {
		SpringContextHelper.context = context;
	}

	public static boolean isContextReady(){
		return context != null;
	}

	/**
	 * 从spring bean factory中获得一个bean
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name){
		return (T) getContext().getBean(name);
	}
}