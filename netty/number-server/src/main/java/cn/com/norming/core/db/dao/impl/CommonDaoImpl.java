package cn.com.norming.core.db.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cn.com.norming.core.db.dao.CommonDao;


public class CommonDaoImpl extends JdbcDaoSupport implements CommonDao {

	@Override
	public int findDataCount(String finalSql) {
		
		return this.getJdbcTemplate().queryForObject(finalSql, Integer.class);
	}
	
	
	@Override
	public int findDataCount(String finalSql, Object[] args) {
		
		return this.getJdbcTemplate().queryForObject(finalSql, args, Integer.class);
	}
	
	
	@Override
	public Map<String, Object> findDataMap(String finalSql) {
		
		List<Map<String, Object>> list = this.findDataList(finalSql);
		
		if (list.size() == 0) {
			return null;
		}
		
		return list.get(0);
	}

	
	@Override
	public Map<String, Object> findDataMap(String finalSql, Object[] object) {
		
		List<Map<String, Object>> list = this.findDataList(finalSql, object);
		
		if (list.size() == 0) {
			return null;
		}
		
		return list.get(0);
	}
	
	
	@Override
	public List<Map<String, Object>> findDataList(String finalSql) {
		
		return this.getJdbcTemplate().queryForList(finalSql);
	}
	

	@Override
	public List<Map<String, Object>> findDataList(String finalSql, Object[] object) {
		
		return this.getJdbcTemplate().queryForList(finalSql, object);
	}
	


	@Override
	public int delDataInfoById(String finalSql) {
		
		return this.getJdbcTemplate().update(finalSql);
	}
	
	
	@Override
	public int delDataInfoById(String finalSql, Object[] object) {
		
		return this.getJdbcTemplate().update(finalSql, object);
	}


	@Override
	public int insertDataInfo(String finalSql) {
		
		return this.getJdbcTemplate().update(finalSql);
	}

	@Override
	public int insertDataInfo(String finalSql, Object[] object) {
		
		return this.getJdbcTemplate().update(finalSql, object);
	}
	

	@Override
	public int updateDataInfo(String finalSql) {
		
		return this.getJdbcTemplate().update(finalSql);
	}

	
	@Override
	public int updateDataInfo(String finalSql, Object[] object) {
		
		return this.getJdbcTemplate().update(finalSql, object);
	}
	
	
	@Override
	public int[] batchDataInfo(String[] finalSql) {
		
		return this.getJdbcTemplate().batchUpdate(finalSql);
		
	}
	
	@Override
	public void executeSqls2(Iterable<Object[]> sqls) {
		for (Object[] ds : sqls) {
			updateDataInfo((String) ds[0], ds.length > 1 ? (Object[]) ds[1] : null);
		}
	}
	
	@Override
	public void executeSql(Object[] ds) {
		updateDataInfo((String) ds[0], ds.length > 1 ? (Object[]) ds[1] : null);
	}
	
	@Override
	public Connection findConnection() {
		Connection conn = null;
		try {
			conn = this.getJdbcTemplate().getDataSource().getConnection();
		} catch (Exception ex) {
			try {
				logger.debug("findConnection Method: is null");
			} catch (EmptyResultDataAccessException e) {   
	            return null;   
	        }
		}
		return conn;
	} 
}