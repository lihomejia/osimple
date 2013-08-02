package com.norming.ess.framework.dao.impl;

import com.norming.ess.common.dao.impl.CommonDaoImpl;
import com.norming.ess.framework.dao.ILoginDao;
import com.norming.ess.user.domain.Ssuser;

public class LoginDaoImpl extends CommonDaoImpl implements ILoginDao {

	@Override
	public Ssuser findUserById(String id) {
		String sql = "select SSUSER_USERID, SSUSER_USERNAME, SSUSER_PWD, SSUSER_ENTITYID from SSUSER where SSUSER_USERID = ?";
		return super.queryForObject(sql, new Object[] {id}, Ssuser.class);
	}

	@Override
	public void update1() {
		super.getJdbcTemplate().update("update ssuser set SSUSER_USERNAME = 'bbbbbbbbb'");
	}

	@Override
	public void update2() {
		super.getJdbcTemplate().update("update ssuser1 set SSUSER_USERNAME = 'bbbbbbbbb'");
	}
	

}
