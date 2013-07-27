package cn.com.norming.framework.service.impl;

import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;

import cn.com.norming.framework.LoginConstants;
import cn.com.norming.framework.LoginException;
import cn.com.norming.framework.dao.ILoginDao;
import cn.com.norming.framework.service.ILoginService;
import cn.com.norming.framework.service.IMainService;
import cn.com.norming.user.domain.User;

public class LoginServiceImpl implements ILoginService {

	private ILoginDao loginDao;
	private IMainService mainService;

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public void setMainService(IMainService mainService) {
		this.mainService = mainService;
	}

	@Override
	public User doLogin(String userid, String userpwd) throws LoginException {
		int index = userid.indexOf('@');
		if (index == -1) {
			throw LoginConstants.USERID_INVALID_FORMAT;
		}
		String flag = userid.substring(index + 1);
		Map<String, Object> mCompany = this.mainService.findCompanyByFlag(flag);
		
		if (mCompany == null) {
			throw LoginConstants.USERID_NOT_EXISTS;
		}
		
		String comId = ObjectUtils.toString(mCompany.get("NMCOMS_COMID"));
		
		User user = loginDao.findUserById(userid, comId);
		
		if (user == null) {
			throw LoginConstants.USERID_NOT_EXISTS;
		}
		
		if (!userpwd.equals(user.getSsuserPwd())) {
			throw LoginConstants.USERID_INVALID_PASSWORD;
		}
		
		return user;
	}
}
