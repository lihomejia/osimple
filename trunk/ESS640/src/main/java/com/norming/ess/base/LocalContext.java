package com.norming.ess.base;

import com.norming.ess.base.util.LocalHelper;
import com.norming.ess.framework.domain.UserInformation;

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
