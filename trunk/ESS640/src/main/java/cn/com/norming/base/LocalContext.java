package cn.com.norming.base;

import cn.com.norming.base.util.LocalHelper;
import cn.com.norming.user.domain.User;

public class LocalContext {
	
	private static final ThreadLocal<User> user = LocalHelper.registStatic(new ThreadLocal<User>());
	
	public static void setUser(User user) {
		LocalContext.user.set(user);
	}
	
	public User getUser() {
		return user.get();
	}

}
