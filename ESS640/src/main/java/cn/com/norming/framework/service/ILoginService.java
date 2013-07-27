package cn.com.norming.framework.service;

import cn.com.norming.framework.LoginException;
import cn.com.norming.user.domain.User;

public interface ILoginService {
	
	User doLogin(String userid, String userpwd) throws LoginException;
}
