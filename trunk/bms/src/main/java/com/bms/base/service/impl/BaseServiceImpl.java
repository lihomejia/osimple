package com.bms.base.service.impl;

import java.util.Date;
import java.util.List;

import com.bms.base.dao.IBaseDao;
import com.bms.base.domain.BaseDomain;
import com.bms.base.service.IBaseService;


public abstract class BaseServiceImpl<T extends BaseDomain> implements IBaseService<T> {
	
	protected abstract IBaseDao<T> get();

	@Override
	public int save(T t) {
		t.setCuserId(0);//TODO
		t.setCdate(new Date());
		t.setUuserId(0);//TODO
		t.setUdate(new Date());
		return get().insert(t);
	}
	
	@Override
	public int update(T t) {
		t.setUuserId(0);//TODO
		t.setUdate(new Date());
		return get().update(t);
	}
	
	@Override
	public int deleteById(Integer id) {
		return get().deleteById(id);
	}
	
	@Override
	public List<T> findList() {
		return get().findList();
	}
	
	@Override
	public List<T> findList(T t) {
		return get().findList(t);
	}

	@Override
	public List<T> findList(String sql, Object... args) {
		return get().findList(sql, args);
	}
	
	@Override
	public T findById(Integer id) {
		return get().findById(id);
	}
	
	@Override
	public T findBean(T t) {
		return get().findBean(t);
	}
	
	@Override
	public T findBean(String sql, Object... args) {
		return get().findBean(sql, args);
	}
}