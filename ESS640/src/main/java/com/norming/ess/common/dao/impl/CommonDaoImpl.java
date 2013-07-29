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
package com.norming.ess.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.norming.ess.common.dao.CommonDao;



public class CommonDaoImpl extends JdbcDaoSupport implements CommonDao {

	/*
	 * (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#query(java.lang.String, java.lang.Class)
	 */
	public <T> List<T> query(String sql, Class<T> clazz) throws DataAccessException {
		return super.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<T>(clazz));
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#query(java.lang.String, java.lang.Object[], java.lang.Class)
	 */
	public <T> List<T> query(String sql, Object[] args, Class<T> clazz) throws DataAccessException {
		return super.getJdbcTemplate().query(sql, args, new BeanPropertyRowMapper<T>(clazz));
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#queryForObject(java.lang.String, java.lang.Class)
	 */
	public <T> T queryForObject(String sql, Class<T> clazz) throws DataAccessException {
		List<T> list = this.query(sql, clazz);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#queryForObject(java.lang.String, java.lang.Object[], java.lang.Class)
	 */
	public <T> T queryForObject(String sql, Object[] args, Class<T> clazz) throws DataAccessException {
		List<T> list = this.query(sql, args, clazz);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	
	public Map<String, Object> queryForMap(String sql) throws DataAccessException {
		List<Map<String, Object>> list = super.getJdbcTemplate().queryForList(sql);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#queryForMap(java.lang.String, java.lang.Object[])
	 */
	public Map<String, Object> queryForMap(String sql, Object... args) throws DataAccessException {
		List<Map<String, Object>> list = super.getJdbcTemplate().queryForList(sql, args);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
}