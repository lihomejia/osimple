package com.norming.spring.config;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


/**
 * 自定义的{@link PropertyPlaceholderConfigurer}
 * 为了在代码中可以直接获取locations properties信息，而避免重新读取文件.
 * @author lh.jia
 * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
 *
 */
public class CustomizedPropertyConfigurer extends PropertyPlaceholderConfigurer {
	private static Properties props;
	  
    @Override  
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
  
        super.processProperties(beanFactoryToProcess, props);  
        
        CustomizedPropertyConfigurer.props = props;
    }  
  
    //static method for accessing context properties  
    public static String getProperty(String key) {
        return props.getProperty(key);  
    }  
}
