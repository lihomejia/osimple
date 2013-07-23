package cn.com.norming.user.dao;

import java.util.List;

import cn.com.norming.user.domain.User;

public interface IUserDao {
	List<User> selectAll();
	
	User selectById(String id);
	
	int insert(User user);
	
	int update(User user);
	
	int deleteUser(String id);
}
