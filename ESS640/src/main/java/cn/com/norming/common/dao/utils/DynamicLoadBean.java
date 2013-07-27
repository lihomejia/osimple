package cn.com.norming.common.dao.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 动态加载Spring配置文件.
 * @author lh.jia
 * @date 2013.02.05
 */
public class DynamicLoadBean implements ApplicationContextAware {

	private ApplicationContext applicationContext = null;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	/**
	 * 加载.
	 * @param configLocationString
	 */
	public void loadBean(String configLocationString) {
		DefaultListableBeanFactory  beanFactory = 
			(DefaultListableBeanFactory ) this.applicationContext.getAutowireCapableBeanFactory();
		
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(configLocationString);
	}

	
}