/**
 * Copyright (C) Norming Information Technology Co.,Ltd. 2012. All 
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
package com.norming.core.db.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Norming持久层API公用服务接口类
 * 任何持久层操作以及获取数据源的操作必须继承此类。不允许越过数据库连接池自行获取dataSource
 */
public interface CommonDao {
	
	String BEAN_NAME = "commonDaoSupport";
	public static final String	DBTYPE_SQLSERVER	= "sqlserver";
	public static final String	DBTYPE_ORACLE		= "oracle";
	public static final String	DBTYPE_DB2			= "db2";
	public static final String	DBTYPE_MYSQL		= "mysql";
	
	/**
	 * 	通过SQL返回查询的总数据条数 
	 * 
	 * @param String 型SQL.如：finalSql = "SELECT COUNT(*) FROM user";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return int型整数。总数据条数。	 */
	public int findDataCount(String finalSql);
	
	/**
	 * 	通过SQL返回查询的总数据条数 
	 * 
	 * @param String 型SQL.如：finalSql = "SELECT COUNT(*) FROM user WHERE user_id=?";
	 * *@param object[]对象数组 如：new Object[] {'01'}
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return int型整数。总数据条数。
	 */
	public int findDataCount(String finalSql, Object[] object);
	
	/**
	 * 	通过SQL返回查询对象的集合。List<?>
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user";
	 * @param object型对象.如：USER.class
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return List<E> 对象数组。	 */
	public Map<String, Object> findDataMap(String finalSql);
	
	/**
	 * 	通过SQL返回查询对象的集合。Map
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user WHERE user_id='01'";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return Map HashMap。
	 */
	public Map<String, Object> findDataMap(String finalSql, Object[] object);
	
	/**
	 * 	通过SQL返回查询对象的集合。List<?>
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user";
	 * @param object型对象.如：USER.class
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return List<E> 对象数组。
	 */
	public List<Map<String, Object>> findDataList(String finalSql);
	
	/**
	 * 	通过SQL返回查询对象的集合。List<?>
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user";
	 * @param object[]对象数组 如：new Object[] {'01'}
	 * @author LiRui
	 * @date Aug 24, 2012
	 * @return List<E> 对象数组。	 */
	public List<Map<String, Object>> findDataList(String finalSql, Object[] object);
	


	/**
	 * 	通过SQL删除数据信息。(接口1)
	 * 
	 * @param String型SQL.如：finalSql = "DELETE FROM user WHERE user_id = '01'";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return 影响的数据行数.
	 */
	public int delDataInfoById(String finalSql);

	/**
	 * 	通过SQL删除数据信息。（接口2）
	 * 
	 * @param String型SQL.如：finalSql = "DELETE FROM user WHERE user_id = '?'";
	 * @param object[]对象数组 如：new Object[] {'01'}
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return 影响的数据行数.
	 */
	public int delDataInfoById(String finalSql ,Object[] object);

	/**
	 *  通过SQL添加数据信息（接口1）
	 * 
	 * @param String型SQL.如：finalSql = "INSERT INTO user VALUES('','','')";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return 影响的数据行数.
	 */
	public int insertDataInfo(String finalSql);
	
	/**
	 *  通过SQL添加数据信息（接口2）
	 * 
	 * @param String型SQL.如：finalSql = "INSERT INTO user VALUES(?,?,?)";
	 * @param object[]对象数组 如：new Object[] {'1','2','3'}
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return 影响的数据行数.
	 */
	public int insertDataInfo(String finalSql, Object[] object);

	/**
	 * 通过SQL修改数据信息（接口1）	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET name='1' WHERE user_id='01'";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return 影响的数据行数.
	 */
	public int updateDataInfo(String finalSql);
	
	/**
	 *  通过SQL修改数据信息（接口2）
	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET user_name=?,user_age=? WHERE user_id=?";
	 * @param object[]对象数组 如：new Object[] {'jack','20','0001'}
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return 影响的数据行数.
	 */
	public int updateDataInfo(String finalSql, Object[] object);
	
	/**
	 * 	通过SQL[] 批量处理数据。	 * 
	 * @param String[]型SQL.如：finalSql.toArray(new String[finalSql.size()])
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return 影响的数据行数[].
	 */
	public int[] batchDataInfo(String[] finalSql);
	
	
	/**
	 * 
	 * @param sqls
	 */
	public void executeSqls2(Iterable<Object[]> sqls);
	
	/**
	 * 
	 * @param sql
	 */
	public void executeSql(Object[] ds);
	
	/**
	 * 通过dao获取connection供存储过程调用.
	 * @return
	 */
	public Connection findConnection();
}
