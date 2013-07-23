package cn.com.norming.user.service.impl;

import java.util.List;

import cn.com.norming.user.dao.IUserDao;
import cn.com.norming.user.domain.User;
import cn.com.norming.user.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public int addUser(User user) {
		return userDao.insert(user);
	}

	public int editUser(User user) {
		return userDao.update(user);
	}

	public List<User> findAll() {
		return userDao.selectAll();
	}

	public User findUserById(String id) {
		return userDao.selectById(id);
	}

	public int deleteUser(String id) {
		return userDao.deleteUser(id);
	}

}
