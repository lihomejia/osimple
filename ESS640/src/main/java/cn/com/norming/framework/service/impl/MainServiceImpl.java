package cn.com.norming.framework.service.impl;

import java.util.Map;

import cn.com.norming.framework.dao.IMainDao;
import cn.com.norming.framework.service.IMainService;

public class MainServiceImpl implements IMainService {
	
	private IMainDao mainDao;
	
	public void setMainDao(IMainDao mainDao) {
		this.mainDao = mainDao;
	}

	@Override
	public Map<String, Object> findCompanyByFlag(String flag) {
		return this.mainDao.findCompanyByFlag(flag.toLowerCase());
	}

}
