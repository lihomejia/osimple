package com.norming.ess.framework.service;

import com.norming.ess.framework.LoginException;
import com.norming.ess.framework.domain.UserInformation;

public interface ILoginService {
	
	UserInformation doLogin(String userid, String userpwd) throws LoginException;
}
