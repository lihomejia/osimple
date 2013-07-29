package com.norming.ess.base.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.norming.ess.common.init.AppContext;



public class SpringContextLoaderListener extends ContextLoaderListener {
	
	/**
	 * Initialize the root web application context.
	 */
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext sc = event.getServletContext();		
		
		// 一定要保证AppContext的部分信息的初始化在Spring正式初始化之前完成!!!
		AppContext.setAppPath(sc.getRealPath("/"));
	
		super.contextInitialized(event);
	}
}