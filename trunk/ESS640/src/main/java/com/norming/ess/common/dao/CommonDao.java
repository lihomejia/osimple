/**
 * Copyright (C) Norming Information Technology Co.,Ltd. 2013. All 
 * rights reserved.
 *
 * This software is covered by the license agreement between the end user and
 * Norming Information Technology Co.,LTD., and may be used and copied 
 * only in accordance with the terms of the said agreement.
 * 
 * Norming Information Science Co.,LTD. assumes no responsibility or 
 * liability for any errors or inaccuracies in this software, 
 * or any consequential, incidental or indirect damage arising out of the use 
 * of the software.
 */
package com.norming.ess.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Norming持久层API公用服务接口类.  2.0
 * @author LiRui
 * @param <T>
 * @date Jul 12, 2012
 * 
 * @edit June. 25,2013 去除Spring3废弃方法。并对新方法增强！并新增接口
 * 
 * 任何持久层操作以及获取数据源的操作必须继承此类。不允许越过数据库连接池自行获取dataSource
 */
public interface CommonDao {
	
	String BEAN_NAME    = "commonDao";
	String BEAN_DYNAMIC = "commonDaoDynamic";
	
	JdbcTemplate getJdbcTemplate();
	
	<T> List<T> query(String sql, Class<T> clazz) throws DataAccessException;
	
	<T> List<T> query(String sql, Object[] args, Class<T> clazz) throws DataAccessException;
	
	<T> T queryForObject(String sql, Class<T> clazz) throws DataAccessException;
	
	<T> T queryForObject(String sql, Object[] args, Class<T> clazz) throws DataAccessException;
	
	Map<String, Object> queryForMap(String sql) throws DataAccessException;
	
	Map<String, Object> queryForMap(String sql, Object... args) throws DataAccessException;
}
