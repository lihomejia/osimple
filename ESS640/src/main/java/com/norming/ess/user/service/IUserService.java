package com.norming.ess.user.service;

import java.util.List;

import com.norming.ess.user.domain.Ssuser;

public interface IUserService {
	
	String BEAN_NAME= "userService";
	
	List<Ssuser> findAll();
	
	Ssuser findUserById(String id);
	
	int editUser(Ssuser user);
	
	int addUser(Ssuser user);
	
	int deleteUser(String id);
}
