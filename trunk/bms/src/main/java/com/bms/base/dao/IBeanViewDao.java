package com.bms.base.dao;

import java.util.List;

public interface IBeanViewDao<T> {

	List<T> queryList(String sql, Object[] pros, Class<T> cls);
	
	int getCount(String sql, Object[] pros);
}
