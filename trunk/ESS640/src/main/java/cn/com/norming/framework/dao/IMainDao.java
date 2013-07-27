package cn.com.norming.framework.dao;

import java.util.Map;

public interface IMainDao {

	Map<String, Object> findCompanyByFlag(String flag);
}
