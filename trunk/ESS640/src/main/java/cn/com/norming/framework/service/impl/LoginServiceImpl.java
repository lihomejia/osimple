package cn.com.norming.framework.service.impl;

import cn.com.norming.framework.LoginConstants;
import cn.com.norming.framework.LoginException;
import cn.com.norming.framework.dao.ILoginDao;
import cn.com.norming.framework.domain.UserInformation;
import cn.com.norming.framework.service.ILoginService;
import cn.com.norming.user.domain.User;

public class LoginServiceImpl implements ILoginService {

	private ILoginDao loginDao;

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public UserInformation doLogin(String userid, String userpwd) throws LoginException {
		userid = userid.toUpperCase();
		User user = loginDao.findUserById(userid);
		
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
		
		return userInfo;
	}
}
