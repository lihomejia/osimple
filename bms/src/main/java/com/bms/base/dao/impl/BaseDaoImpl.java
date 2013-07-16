package com.bms.base.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bms.base.dao.IBaseDao;
import com.bms.base.domain.BaseDomain;
import com.bms.base.domain.BaseDomainlUtil;
import com.bms.base.util.sql.SqlResult;


public class BaseDaoImpl<T extends BaseDomain> implements IBaseDao<T> {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	private Class<T> clazz;
	private String tableName;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] types = ((ParameterizedType) type).getActualTypeArguments();
			if (types != null && types.length > 0){
				this.clazz = (Class<T>) types[0];
				this.tableName = BaseDomainlUtil.getTableName(this.clazz);
			}
		}
	}
	
	@Override
	public int insert(T t) {
		t.setCdate(new Date());
		return BaseDomainlUtil.insert(jdbcTemplate, t);
	}

	@Override
	public int update(T t) {
		return BaseDomainlUtil.update(jdbcTemplate, t);
	}
	
	@Override
	public int deleteById(Integer id) {
		String sql = "delete from " + tableName + " where id=?";
		return jdbcTemplate.update(sql, id);
	}
	
	@Override
	public List<T> findList() {
		return this.findList("select * from " + tableName);
	}

	@Override
	public List<T> findList(String sql, Object... args) {
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(clazz), args);
	}
	
	@Override
	public List<T> findList(T t) {
		SqlResult result = BaseDomainlUtil.getSelectSql(t);
		return this.findList(result.getSql(), result.getValues());
	}
	
	@Override
	public T findById(Integer id) {
		String sql = "select * from " + tableName + " where id=?";
		return this.findBean(sql, id);
	}

	@Override
	public T findBean(T t) {
		SqlResult result = BaseDomainlUtil.getSelectSql(t);
		return this.findBean(result.getSql(), result.getValues());
	}
	
	@Override
	public T findBean(String sql, Object... args) {
		List<T> list = this.findList(sql, args);
		if (list.size() > 0) return list.get(0);
		return null;
	}

	public String getTableName() {
		return tableName;
	}
}