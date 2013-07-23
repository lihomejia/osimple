package cn.com.norming.user.dao.impl;

import java.util.List;

import cn.com.norming.common.dao.impl.CommonDaoImpl;
import cn.com.norming.user.dao.IUserDao;
import cn.com.norming.user.domain.User;

public class UserDaoImpl extends CommonDaoImpl implements IUserDao {
	
	public List<User> selectAll() {
		String querySql = "select SSUSER_USERID, SSUSER_USERNAME, SSUSER_PWD from SSUSER";
		return super.query(querySql, User.class);
	}
	
	public User selectById(String id) {
		String querySql = "select SSUSER_USERID,SSUSER_USERNAME,SSUSER_PWD from SSUSER where SSUSER_USERID = ?";
		return super.queryForObject(querySql, new Object[] {id}, User.class);
	}
	
	public int insert(User user) {
		String insertSql = "INSERT INTO SSUSER (SSUSER_USERID,SSUSER_PWD) VALUES(?,?)";
		return super.getJdbcTemplate().update(insertSql, user.getSsuserUserid(), user.getSsuserPwd());
	}
	
	public int update(User user) {
		String updateSql = "update SSUSER set SSUSER_PWD=? where SSUSER_USERID=?";
		return super.getJdbcTemplate().update(updateSql, user.getSsuserPwd(), user.getSsuserUserid());
	}

	public int deleteUser(String id) {
		String deleteSql = "delete from SSUSER where SSUSER_USERID=?";
		return super.getJdbcTemplate().update(deleteSql, id);
	}
}