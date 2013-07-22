package cn.com.norming.user.service.impl;

import java.util.List;

import cn.com.norming.user.dao.IUserDao;
import cn.com.norming.user.domain.Ssuser;
import cn.com.norming.user.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public int addUser(Ssuser user) {
		return userDao.insert(user);
	}

	public int editUser(Ssuser user) {
		return userDao.update(user);
	}

	public List<Ssuser> findAll() {
		return userDao.selectAll();
	}

	public Ssuser findUserById(String id) {
		return userDao.selectById(id);
	}

	public int deleteUser(String id) {
		return userDao.deleteUser(id);
	}

}
