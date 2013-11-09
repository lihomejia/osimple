package com.bms.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.resource.dao.IDictDao;
import com.bms.resource.domain.Dict;
import com.bms.resource.service.IDictService;

@Service
public class DictServiceImpl implements IDictService {

	@Autowired
	private IDictDao dao;
	
	@Override
	public List<Dict> findList() {
		return dao.findList();
	}

}
