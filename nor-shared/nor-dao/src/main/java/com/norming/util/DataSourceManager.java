package com.norming.util;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.Assert;

import com.norming.domain.PoolProperties;
import com.norming.spring.config.CustomizedPropertyConfigurer;

public class DataSourceManager {
	
	public static final String BEAN_PREFIX = "dataSource";
	private static final String TEMPLATE_BEAN = "dataSource";
	
	
	
	public static void add(ConfigurableListableBeanFactory beanFactory, String comId, PoolProperties pprop) {
		
		checkBeanFactory(beanFactory);
		
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
		
		//obtain dataSource beanDefinition
		BeanDefinition template = registry.getBeanDefinition(TEMPLATE_BEAN);
		
		//copy beanDefinition information from main dataSource  
		GenericBeanDefinition bd = new GenericBeanDefinition(template);
		
		MutablePropertyValues mpv = new MutablePropertyValues(template.getPropertyValues());
		
		String urlTpl = CustomizedPropertyConfigurer.getProperty("jdbc.urlTpl");
		
		String dbServer = pprop.getDbServer();
		String dbName 	= pprop.getDbName();
		String dbPort 	= String.valueOf(pprop.getDbPort());
		
		String url = urlTpl.replace("$server$", dbServer).replace("$port$", dbPort).replace("$dbname$", dbName);
		
		if ("org.apache.tomcat.jdbc.pool.DataSource".equals(bd.getBeanClassName())) {
			
			//Required Parameters
			mpv.add("url",                        url);
			mpv.add("username",                   pprop.getUsername());
			mpv.add("password",                   pprop.getPassword());
			
			//
			mpv.add("initialSize",                pprop.getInitialSize());
			mpv.add("maxActive",                  pprop.getMaxActive());
			mpv.add("maxIdle",                    pprop.getMaxIdle());
			mpv.add("minIdle",                    pprop.getMinIdle());
			mpv.add("maxWait",                    pprop.getMaxWait());
			
			//Other Parameters
			mpv.add("removeAbandoned",            pprop.isRemoveAbandoned());
			mpv.add("removeAbandonedTimeout",     pprop.getRemoveAbandonedTimeout());
			mpv.add("validationQuery",            pprop.getValidationQuery());
			
		} else if ("org.apache.commons.dbcp.BasicDataSource".equals(bd.getBeanClassName())) {
			//Required Parameters
			mpv.add("url",                        url);
			mpv.add("username",                   pprop.getUsername());
			mpv.add("password",                   pprop.getPassword());
			
			//
			mpv.add("initialSize",                pprop.getInitialSize());
			mpv.add("maxActive",                  pprop.getMaxActive());
			mpv.add("maxIdle",                    pprop.getMaxIdle());
			mpv.add("minIdle",                    pprop.getMinIdle());
			mpv.add("maxWait",                    pprop.getMaxWait());
			
			//Other Parameters
			mpv.add("removeAbandoned",            pprop.isRemoveAbandoned());
			mpv.add("removeAbandonedTimeout",     pprop.getRemoveAbandonedTimeout());
			mpv.add("validationQuery",            pprop.getValidationQuery());
			
		} else if ("com.mchange.v2.c3p0.ComboPooledDataSource".equals(bd.getBeanClassName())) {
			
			//Required Parameters
			mpv.add("jdbcUrl",                    url);
			mpv.add("user",                       pprop.getUsername());
			mpv.add("password",                   pprop.getPassword());
			
			//
			mpv.add("initialPoolSize",            pprop.getInitialSize());
			mpv.add("minPoolSize", 	              1);
			mpv.add("maxPoolSize",                pprop.getMaxActive());
			mpv.add("acquireIncrement",           1);
			mpv.add("maxIdleTime",                60);
			
			//Other Parameters
			mpv.add("idleConnectionTestPeriod",   120);
			mpv.add("maxStatements",              30);
			mpv.add("maxStatementsPerConnection", 3);
			mpv.add("acquireRetryDelay",          1000);
			mpv.add("acquireRetryAttempts",       3);
			mpv.add("testConnectionOnCheckout",   false);
			mpv.add("testConnectionOnCheckin",    false);
			mpv.add("breakAfterAcquireFailure",   false);
		}
		
		bd.setPropertyValues(mpv);
		
		String beanId = BEAN_PREFIX + comId;
		
		//Register a new dataSource definition with registry.
		registry.registerBeanDefinition(beanId, bd);
	}
	
	
	public static void remove(ConfigurableListableBeanFactory beanFactory, String beanId) {
		
		checkBeanFactory(beanFactory);
		
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
		
		registry.removeBeanDefinition(beanId);
	}
	
	
	private static void checkBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		Assert.isInstanceOf(BeanDefinitionRegistry.class, beanFactory, 
				"ConfigurableListableBeanFactory must be instance of [" + BeanDefinitionRegistry.class.getName() + "]");
	}
}