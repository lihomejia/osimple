package cn.com.norming.framework.dao;

import cn.com.norming.user.domain.Ssuser;

public interface ILoginDao {

	Ssuser findUserById(String id);
}
