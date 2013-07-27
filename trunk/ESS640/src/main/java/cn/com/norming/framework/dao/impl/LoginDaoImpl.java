package cn.com.norming.framework.dao.impl;

import cn.com.norming.common.dao.impl.CommonDaoImpl;
import cn.com.norming.common.dao.utils.DynamicDataSource;
import cn.com.norming.framework.dao.ILoginDao;
import cn.com.norming.user.domain.User;

public class LoginDaoImpl extends CommonDaoImpl implements ILoginDao {

	private DynamicDataSource dynamicDataSource;
	
	public void setDynamicDataSource(DynamicDataSource dynamicDataSource) {
		this.dynamicDataSource = dynamicDataSource;
	}



	@Override
	public User findUserById(String id, String comId) {
		this.setDataSource(dynamicDataSource.getDataSourceByEntity(comId));
		
		String sql = "select SSUSER_USERID, SSUSER_USERNAME, SSUSER_PWD from SSUSER where SSUSER_USERID = ?";
		return super.queryForObject(sql, new Object[] {id}, User.class);
	}

}