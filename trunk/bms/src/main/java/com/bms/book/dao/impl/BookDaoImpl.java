package com.bms.book.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bms.book.dao.IBookDao;
import com.bms.book.domain.Book;

@Repository
public class BookDaoImpl implements IBookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Book> findList() {
		String sql = "select * from t_book";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
	}

}
