package com.norming.netty.config;

import java.util.Properties;

public class NettyConfig {
	
	/** 多值分隔符 */
	public static final String MUL_SPLITOR = "|";

	// 系统内部变量
	private static Properties ps = new Properties();

	private static final String CONFIG_FILE_NAME 	= "netty.properties";
	
	public static final String NETTY_HOST 			= "netty.host";
	public static final String NETTY_REFRESH_PORT 	= "netty.refresh.port";
	
	static {
		init();
	}
	
	private static void init() {
		ps = new Properties();
		try {
			ps.load(NettyConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public static String get(String key) {
		return ps.getProperty(key);
	}
	
	public static String get(String key, String def) {
		String p = ps.getProperty(key);
		if (p == null) {
			warnMsg("PS value not found, key(" + key + "), using default value(" + def + ")");
		}
		return p == null ? def : p;
	}
	
	public static Integer getInt(String key) {
		return getInt(key, 0);
	}

	/**
	 * 获得一个属性值的数字格式数据,未能获得有效值,则返回默认值 
	 * 
	 * @param key
	 * @param def
	 * @return
	 */
	public static Integer getInt(String key, Integer def) {
		try {
			return Integer.parseInt(get(key));
		} catch (NumberFormatException e) {
			return def;
		}
	}
	
	private static void warnMsg(String msg) {
		System.err.println(msg);
	}
}
