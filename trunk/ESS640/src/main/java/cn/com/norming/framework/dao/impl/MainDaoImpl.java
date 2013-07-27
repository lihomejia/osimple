package cn.com.norming.framework.dao.impl;

import java.util.Map;

import cn.com.norming.common.dao.impl.CommonDaoImpl;
import cn.com.norming.framework.dao.IMainDao;

public class MainDaoImpl extends CommonDaoImpl implements IMainDao {

	@Override
	public Map<String, Object> findCompanyByFlag(String flag) {
		return queryForMap("select NMCOMS_COMID from NMCOMS where NMCOMS_FLAG=?", flag);
	}

}
