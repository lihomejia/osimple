package cn.com.norming.base;

import cn.com.norming.base.util.LocalHelper;
import cn.com.norming.framework.domain.UserInformation;

public class LocalContext {
	
	private static final ThreadLocal<UserInformation> user = LocalHelper.registStatic(new ThreadLocal<UserInformation>());
	
	public static void setUser(UserInformation user) {
		LocalContext.user.set(user);
	}
	
	public UserInformation getUser() {
		return user.get();
	}

}
