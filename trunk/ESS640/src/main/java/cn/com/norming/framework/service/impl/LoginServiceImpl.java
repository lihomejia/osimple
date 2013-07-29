package cn.com.norming.framework.service.impl;

import cn.com.norming.framework.LoginConstants;
import cn.com.norming.framework.LoginException;
import cn.com.norming.framework.dao.ILoginDao;
import cn.com.norming.framework.service.ILoginService;
import cn.com.norming.user.domain.User;

public class LoginServiceImpl implements ILoginService {

	private ILoginDao loginDao;

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public User doLogin(String userid, String userpwd) throws LoginException {
		userid = userid.toUpperCase();
		User user = loginDao.findUserById(userid);
		
		if (user == null) {
			throw LoginConstants.USERID_NOT_EXISTS;
		}
		
		if (!userpwd.equals(user.getSsuserPwd())) {
			throw LoginConstants.USERID_INVALID_PASSWORD;
		}
		
		return user;
	}
}
