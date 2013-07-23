package cn.com.norming.framework.service.impl;

import org.springframework.stereotype.Service;

import cn.com.norming.base.util.LocalHelper;
import cn.com.norming.framework.service.UserSuportable;
import cn.com.norming.user.domain.Ssuser;

@Service
public class LocalContext implements UserSuportable {
	
	private static final ThreadLocal<Ssuser> user = LocalHelper.registStatic(new ThreadLocal<Ssuser>());
	
	public static void setUser(Ssuser user) {
		LocalContext.user.set(user);
	}
	
	public Ssuser getUser() {
		return user.get();
	}

}
