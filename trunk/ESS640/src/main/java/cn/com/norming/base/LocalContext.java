package cn.com.norming.base;

import cn.com.norming.base.util.LocalHelper;
import cn.com.norming.framework.domain.UserInformation;

public class LocalContext {
	
	private static final ThreadLocal<UserInformation> user = LocalHelper.registStatic(new ThreadLocal<UserInformation>());
	
	public static void setUser(UserInformation user) {
		LocalContext.user.set(user);
	}
	
	public static UserInformation getUser() {
		return user.get();
	}
	
	public static String getEntityId() {
	    UserInformation user = getUser();
        return user == null ? null : user.getEntityId();
	}
}
