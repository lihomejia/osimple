package com.hong.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	private static final String CONFIG_FILE_NAME = "goal.properties";
	
	public final static String HOST = "host";
	
	public final static String FILEPATH = "filepath";
	
	public final static String MAPPINGHOST = "mappinghost";
	
	private static Properties ps = new Properties();
	
	static {
		try {
			ps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		return ps.getProperty(key);
	}
}
