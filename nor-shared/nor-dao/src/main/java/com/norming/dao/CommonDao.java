package com.norming.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 持久层API公用服务接口类.
 * 
 * 原则上，任何持久层操作以及获取数据源的操作均需访问此API，更不允许越过数据库连接池自行获取dataSource.
 * 
 * 设计意图:
 * ①此接口继承自{@link JdbcOperations}，而{@link JdbcTemplate}同样实现了此接口，所以我们能提供与{@link JdbcTemplate}一致的API.
 * ②定义此接口，可以便捷的扩展{@link JdbcOperations}中没有提供的方法.
 * 
 * @author lh.jia
 * Created on Jan 23, 2015 
 *
 */
public interface CommonDao extends JdbcOperations {
	
	String BEAN_NAME        = "commonDao";
	String BEAN_DYNAMIC     = "commonDaoDynamic";
	
	String DBTYPE_SQLSERVER	= "sqlserver";
	String DBTYPE_ORACLE    = "oracle";
	String DBTYPE_MYSQL     = "mysql";

	
	/**
	 * 查询. 以List<实体类>的格式返回数据.
	 * @param sql SQL语句 
	 * @param clazz 实体类型 
	 * @return List<实体类>
	 * @throws DataAccessException
	 */
	<T> List<T> query(String sql, Class<T> clazz) throws DataAccessException;
	
	<T> List<T> query(String sql, Object[] args, Class<T> clazz) throws DataAccessException;
	
	/**
	 * 查询. 以实体类的格式返回数据.
	 * <pre>
	 * 如果无匹配记录，返回null;
	 * 如果匹配多条，返回第一条;
	 * </pre>
	 * @param sql SQL语句
	 * @param clazz 实体类型 
	 * @return 实体对象T的实例 
	 * @throws DataAccessException
	 */
	<T> T queryForBean(String sql, Class<T> clazz) throws DataAccessException;
	
	<T> T queryForBean(String sql, Object[] args, Class<T> clazz) throws DataAccessException;
}
