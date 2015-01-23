package com.norming.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.norming.dao.CommonDao;

/**
 * 
 * @author lh.jia
 * Created on Jan 23, 2015 
 *
 */
public class CommonDaoImpl extends JdbcTemplateProxy implements CommonDao {

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