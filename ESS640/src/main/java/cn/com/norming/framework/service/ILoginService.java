package cn.com.norming.framework.service;

import cn.com.norming.framework.LoginException;
import cn.com.norming.framework.domain.UserInformation;

public interface ILoginService {
	
	UserInformation doLogin(String userid, String userpwd) throws LoginException;
}
