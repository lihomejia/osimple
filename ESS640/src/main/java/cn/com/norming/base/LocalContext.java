package cn.com.norming.base;

import cn.com.norming.base.util.LocalHelper;
import cn.com.norming.user.domain.Ssuser;

public class LocalContext {
	
	private static final ThreadLocal<Ssuser> user = LocalHelper.registStatic(new ThreadLocal<Ssuser>());
	
	public static void setUser(Ssuser user) {
		LocalContext.user.set(user);
	}
	
	public Ssuser getUser() {
		return user.get();
	}

}
