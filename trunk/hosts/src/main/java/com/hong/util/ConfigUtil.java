package com.hong.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	private static final String CONFIG_FILE_NAME = "goal.properties";
	
	public static final String HOST = "host";
	
	public static final String FILEPATH = "filepath";
	
	public static final String MAPPINGHOST = "mappinghost";
	
	private static final String MUL_SPLITOR = "\\|";
	
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
	
	public static String[] gets(String key) {
		return get(key).split(MUL_SPLITOR);
	}
}
