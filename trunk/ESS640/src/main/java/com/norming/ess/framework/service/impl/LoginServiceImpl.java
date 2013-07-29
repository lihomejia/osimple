package com.norming.ess.framework.service.impl;

import com.norming.ess.framework.LoginConstants;
import com.norming.ess.framework.LoginException;
import com.norming.ess.framework.dao.ILoginDao;
import com.norming.ess.framework.domain.UserInformation;
import com.norming.ess.framework.service.ILoginService;
import com.norming.ess.user.domain.Ssuser;

public class LoginServiceImpl implements ILoginService {

	private ILoginDao loginDao;

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public UserInformation doLogin(String userid, String userpwd) throws LoginException {
		userid = userid.toUpperCase();
		Ssuser user = loginDao.findUserById(userid);
		
		if (user == null) {
			throw LoginConstants.USERID_NOT_EXISTS;
		}
		
		if (!userpwd.equals(user.getSsuserPwd())) {
			throw LoginConstants.USERID_INVALID_PASSWORD;
		}
		
		UserInformation userInfo = new UserInformation(); 
		userInfo.setUserId(user.getSsuserUserid());
		userInfo.setUserName(user.getSsuserPwd());
		userInfo.setUserPwd(user.getSsuserPwd());
		userInfo.setEntityId(user.getSsuserEntityid());
		
		return userInfo;
	}
}
