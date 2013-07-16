package com.bms.resource.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bms.resource.dao.IDictDao;
import com.bms.resource.domain.Dict;

@Repository
public class DictDaoImpl implements IDictDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Dict> findList() {
		return jdbcTemplate.query("select * from t_dict", new BeanPropertyRowMapper<Dict>(Dict.class));
	}
}