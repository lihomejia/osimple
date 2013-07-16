package com.bms.base.service;

import java.util.List;

public interface IBaseService<T> {
	int save(T t);
	
	int update(T t);
	
	int deleteById(Integer id);
	
	List<T> findList();
	
	List<T> findList(T t);

	List<T> findList(String sql, Object... args);
	
	T findById(Integer id);
	
	T findBean(T t);
	
	T findBean(String sql, Object... args);
	
}
