package com.norming.ess.user.dao;

import java.util.List;

import com.norming.ess.user.domain.Ssuser;


public interface IUserDao {
	List<Ssuser> selectAll();
	
	Ssuser selectById(String id);
	
	int insert(Ssuser user);
	
	int update(Ssuser user);
	
	int deleteUser(String id);
}
