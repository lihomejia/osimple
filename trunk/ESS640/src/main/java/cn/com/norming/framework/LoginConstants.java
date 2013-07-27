package cn.com.norming.framework;

public interface LoginConstants {
	
	LoginException USERID_INVALID_FORMAT = new LoginException("用户ID格式无效");
	
	LoginException USERID_NOT_EXISTS = new LoginException("用户ID不存在");
	
	LoginException USERID_INVALID_PASSWORD = new LoginException("用户密码无效");
}
