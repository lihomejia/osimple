package com.norming.ess.framework.service.impl;

import org.springframework.stereotype.Service;

import com.norming.ess.base.util.LocalHelper;
import com.norming.ess.framework.service.UserSuportable;
import com.norming.ess.user.domain.Ssuser;

@Service
public class ServiceContext implements UserSuportable {
	
	private static final ThreadLocal<Ssuser> user = LocalHelper.registStatic(new ThreadLocal<Ssuser>());
	
	public static void setUser(Ssuser user) {
		ServiceContext.user.set(user);
	}
	
	public Ssuser getUser() {
		return user.get();
	}

}
