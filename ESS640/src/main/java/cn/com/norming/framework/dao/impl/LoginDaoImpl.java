package cn.com.norming.framework.dao.impl;

import cn.com.norming.common.dao.impl.CommonDaoImpl;
import cn.com.norming.framework.dao.ILoginDao;
import cn.com.norming.user.domain.Ssuser;

public class LoginDaoImpl extends CommonDaoImpl implements ILoginDao {

	@Override
	public Ssuser findUserById(String id) {
		String sql = "select SSUSER_USERID, SSUSER_USERNAME, SSUSER_PWD, SSUSER_ENTITYID from SSUSER where SSUSER_USERID = ?";
		return super.queryForObject(sql, new Object[] {id}, Ssuser.class);
	}

}
