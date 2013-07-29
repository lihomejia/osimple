package com.norming.ess.framework.dao;

import com.norming.ess.user.domain.Ssuser;

public interface ILoginDao {

	Ssuser findUserById(String id);
}
