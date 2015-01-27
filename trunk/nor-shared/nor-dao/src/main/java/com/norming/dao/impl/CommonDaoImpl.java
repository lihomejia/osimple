package com.norming.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.norming.dao.CommonDao;

/**
 * 本类的功能:
 * ①实现{@link CommonDao}接口中定义的方法.
 * ②修改{@link JdbcTemplateProxy}中个别方法的行为.
 * 
 * @author lh.jia
 * Created on Jan 23, 2015 
 *
 */
public final class CommonDaoImpl extends JdbcTemplateProxy implements CommonDao {

	// =========================================================
	// Implement {@link CommonDao}'s methods >>>Start>>>>>>>>>>>
	// =========================================================

	// [start] query
	public <T> List<T> query(String sql, Class<T> clazz) throws DataAccessException {
		
		return super.query(sql, new BeanPropertyRowMapper<T>(clazz));
	}
	

	public <T> List<T> query(String sql, Object[] args, Class<T> clazz) throws DataAccessException {
		
		return super.query(sql, args, new BeanPropertyRowMapper<T>(clazz));
	}
	// [end] query

	// [start] queryForBean
	public <T> T queryForBean(String sql, Class<T> clazz) throws DataAccessException {
		
		return queryForObject(sql, new BeanPropertyRowMapper<T>(clazz));
	}

	
	public <T> T queryForBean(String sql, Object[] args, Class<T> clazz) throws DataAccessException {
		
		return queryForObject(sql, args, new BeanPropertyRowMapper<T>(clazz));
	}
	// [end] queryForBean

	/**
	 *********************** Separator Line**********************
	 */

	// =========================================================
	// Override {@link JdbcTemplateProxy}'s methods >>>>Start>>>
	// =========================================================

	@Override
	public <T> T queryForObject(String sql, RowMapper<T> rowMapper) throws DataAccessException {
		
		List<T> results = query(sql, rowMapper);
		
		return singleResult(results);
	}

	
	@Override
	public <T> T queryForObject(String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper) 
			throws DataAccessException {
		
		List<T> results = query(sql, args, argTypes, new RowMapperResultSetExtractor<T>(rowMapper, 1));
		
		return singleResult(results);
	}

	
	@Override
	public <T> T queryForObject(String sql, Object[] args, RowMapper<T> rowMapper) 
			throws DataAccessException {
		
		List<T> results = query(sql, args, new RowMapperResultSetExtractor<T>(rowMapper, 1));
		
		return singleResult(results);
	}

	
	@Override
	public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args) 
			throws DataAccessException {
		
		List<T> results = query(sql, args, new RowMapperResultSetExtractor<T>(rowMapper, 1));
		
		return singleResult(results);
	}
	
	/**
	 * 查询. 以Map的格式返回数据.
	 * <pre>
	 * 如果无匹配记录，返回null;
	 * 如果匹配多条，返回第一条;
	 * </pre>
	 * @param sql SQL语句
	 * @return java.util.Map接口对象.
	 * @throws DataAccessException
	 */
	@Override
	public Map<String, Object> queryForMap(String sql) throws DataAccessException {
		List<Map<String, Object>> list = super.queryForList(sql);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * 查询. 以Map的格式返回数据.
	 * 如果无匹配记录，返回null;
	 * 如果匹配多条，返回第一条;
	 * @param sql SQL语句
	 * @param args SQL预处理参数 
	 * @return java.util.Map接口对象.
	 * @throws DataAccessException
	 */
	@Override
	public Map<String, Object> queryForMap(String sql, Object... args) throws DataAccessException {
		List<Map<String, Object>> list = super.queryForList(sql, args);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	/**
	 *********************** Separator Line**********************
	 */

	/**
	 * Return a single result object from the given Collection.
	 * <p>
	 * Returns {@code null} if 0 result objects found;
	 * 
	 * @param results
	 *            the result Collection (can be {@code null})
	 * @return the single result object, or {@code null} if none
	 */
	private static <T> T singleResult(Collection<T> results) {
		if (results == null || results.size() == 0) {
			return null;
		}
		return results.iterator().next();
	}
}