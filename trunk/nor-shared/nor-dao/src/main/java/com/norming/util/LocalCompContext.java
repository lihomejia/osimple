package com.norming.util;

/**
 * 线程锁定 context

 * @see java.lang.ThreadLocal
 */
public class LocalCompContext {

	private static final ThreadLocal<String> comp = new ThreadLocal<String>();


	/**
	 * 获得当前用户场景的公司id.
	 *  (用户公司信息,这样设计的目的是为了支持多公司,每个公司一个数据库.)
	 *  
	 * @return
	 */
	public static String getUserCompany() {
		return comp.get();
	}

	
	/**
	 * 设置用户信息公司ID.
	 * 
	 * @param compId
	 */
	public static void setUserCompany(String compId) {
		comp.set(compId);
	}

	/**
	 * 清除线程绑定的localContext实例.
	 *
	 */
	public static void clearContext() {
		comp.remove();
	}
}