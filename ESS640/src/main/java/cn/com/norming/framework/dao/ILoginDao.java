package cn.com.norming.framework.dao;

import cn.com.norming.user.domain.User;

public interface ILoginDao {

	User findUserById(String id);
}
