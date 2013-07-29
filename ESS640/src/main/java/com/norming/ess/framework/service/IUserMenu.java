package com.norming.ess.framework.service;

import java.util.List;
import java.util.Map;

/**
 * 解析菜单文件服务类 
 * @author lh.jia
 */
public interface IUserMenu {
	
	/**
	 * 得到桌面快捷方式的 菜单项 列表
	 * @author lh.jia
	 * @return 菜单项列表	 */
	List<Map<String, Object>> queryShortcuts();
}
