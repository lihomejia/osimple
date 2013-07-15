package com.norming.ess.user.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.norming.ess.common.dao.impl.CommonDaoImpl;
import com.norming.ess.user.dao.IUserDao;
import com.norming.ess.user.domain.Ssuser;

public class UserDaoImpl extends CommonDaoImpl implements IUserDao {
	
	public List<Ssuser> selectAll() {
		String querySql = "select SSUSER_USERID, SSUSER_USERNAME, SSUSER_PWD from SSUSER";
		return this.query(querySql, Ssuser.class);
	}
	
	public Ssuser selectById(String id) {
		String querySql = "select SSUSER_USERID,SSUSER_USERNAME,SSUSER_PWD from SSUSER where SSUSER_USERID = ?";
		return this.queryForObject(querySql, new BeanPropertyRowMapper<Ssuser>(Ssuser.class),id);
	}
	
	public int insert(Ssuser user) {
		String insertSql = "INSERT INTO SSUSER (SSUSER_USERID,SSUSER_PWD) VALUES(?,?);";
		return this.insert(insertSql, user.getSsuserUserid(), user.getSsuserPwd());
	}
	
	public int update(Ssuser user) {
		String updateSql = "update SSUSER set SSUSER_PWD=? where SSUSER_USERID=?";
		return this.update(updateSql, user.getSsuserPwd(), user.getSsuserUserid());
	}

	@Override
	public int deleteUser(String id) {
		String deleteSql = "delete from SSUSER where SSUSER_USERID=?";
		return this.delete(deleteSql, id);
	}
}