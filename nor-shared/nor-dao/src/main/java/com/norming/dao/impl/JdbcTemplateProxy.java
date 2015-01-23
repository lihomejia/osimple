package com.norming.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * {@link JdbcTemplate} proxy class. 
 * Do not cover original class behavior, also do not add any method.
 * 
 * @author lh.jia
 * Created on Jan 23, 2015 
 *
 */
public class JdbcTemplateProxy extends JdbcDaoSupport implements JdbcOperations {

	@Override
	public <T> T execute(ConnectionCallback<T> action)
			throws DataAccessException {
		return getJdbcTemplate().execute(action);
	}

	@Override
	public <T> T execute(StatementCallback<T> action)
			throws DataAccessException {
		return getJdbcTemplate().execute(action);
	}

	@Override
	public void execute(String sql) throws DataAccessException {
		getJdbcTemplate().execute(sql);
	}

	@Override
	public <T> T query(String sql, ResultSetExtractor<T> rse)
			throws DataAccessException {
		return getJdbcTemplate().query(sql, rse);
	}

	@Override
	public void query(String sql, RowCallbackHandler rch)
			throws DataAccessException {
		getJdbcTemplate().query(sql, rch);
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper)
			throws DataAccessException {
		return getJdbcTemplate().query(sql, rowMapper);
	}

	@Override
	public <T> T queryForObject(String sql, RowMapper<T> rowMapper)
			throws DataAccessException {
		return getJdbcTemplate().queryForObject(sql, rowMapper);
	}

	@Override
	public <T> T queryForObject(String sql, Class<T> requiredType)
			throws DataAccessException {
		return getJdbcTemplate().queryForObject(sql, requiredType);
	}

	@Override
	public Map<String, Object> queryForMap(String sql)
			throws DataAccessException {
		return getJdbcTemplate().queryForMap(sql);
	}

	@Override
	public long queryForLong(String sql) throws DataAccessException {
//		return getJdbcTemplate().queryForLong(sql);
		return getJdbcTemplate().queryForObject(sql, Long.class);
	}

	@Override
	public int queryForInt(String sql) throws DataAccessException {
//		return getJdbcTemplate().queryForInt(sql);
		return getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public <T> List<T> queryForList(String sql, Class<T> elementType)
			throws DataAccessException {
		return getJdbcTemplate().queryForList(sql, elementType);
	}

	@Override
	public List<Map<String, Object>> queryForList(String sql)
			throws DataAccessException {
		return getJdbcTemplate().queryForList(sql);
	}

	@Override
	public SqlRowSet queryForRowSet(String sql) throws DataAccessException {
		return getJdbcTemplate().queryForRowSet(sql);
	}

	@Override
	public int update(String sql) throws DataAccessException {
		return getJdbcTemplate().update(sql);
	}

	@Override
	public int[] batchUpdate(String[] sql) throws DataAccessException {
		return getJdbcTemplate().batchUpdate(sql);
	}

	@Override
	public <T> T execute(PreparedStatementCreator psc,
			PreparedStatementCallback<T> action) throws DataAccessException {
		return getJdbcTemplate().execute(psc, action);
	}

	@Override
	public <T> T execute(String sql, PreparedStatementCallback<T> action)
			throws DataAccessException {
		return getJdbcTemplate().execute(sql, action);
	}

	@Override
	public <T> T query(PreparedStatementCreator psc, ResultSetExtractor<T> rse)
			throws DataAccessException {
		return getJdbcTemplate().query(psc, rse);
	}

	@Override
	public <T> T query(String sql, PreparedStatementSetter pss,
			ResultSetExtractor<T> rse) throws DataAccessException {
		return getJdbcTemplate().query(sql, pss, rse);
	}

	@Override
	public <T> T query(String sql, Object[] args, int[] argTypes,
			ResultSetExtractor<T> rse) throws DataAccessException {
		return getJdbcTemplate().query(sql, args, argTypes, rse);
	}

	@Override
	public <T> T query(String sql, Object[] args, ResultSetExtractor<T> rse)
			throws DataAccessException {
		return getJdbcTemplate().query(sql, args, rse);
	}

	@Override
	public <T> T query(String sql, ResultSetExtractor<T> rse, Object... args)
			throws DataAccessException {
		return getJdbcTemplate().query(sql, rse, args);
	}

	@Override
	public void query(PreparedStatementCreator psc, RowCallbackHandler rch)
			throws DataAccessException {
		getJdbcTemplate().query(psc, rch);
	}

	@Override
	public void query(String sql, PreparedStatementSetter pss,
			RowCallbackHandler rch) throws DataAccessException {
		getJdbcTemplate().query(sql, pss, rch);
	}

	@Override
	public void query(String sql, Object[] args, int[] argTypes,
			RowCallbackHandler rch) throws DataAccessException {
		getJdbcTemplate().query(sql, args, argTypes, rch);
	}

	@Override
	public void query(String sql, Object[] args, RowCallbackHandler rch)
			throws DataAccessException {
		getJdbcTemplate().query(sql, args, rch);
	}

	@Override
	public void query(String sql, RowCallbackHandler rch, Object... args)
			throws DataAccessException {
		getJdbcTemplate().query(sql, rch, args);
	}

	@Override
	public <T> List<T> query(PreparedStatementCreator psc,
			RowMapper<T> rowMapper) throws DataAccessException {
		return getJdbcTemplate().query(psc, rowMapper);
	}

	@Override
	public <T> List<T> query(String sql, PreparedStatementSetter pss,
			RowMapper<T> rowMapper) throws DataAccessException {
		return getJdbcTemplate().query(sql, pss, rowMapper);
	}

	@Override
	public <T> List<T> query(String sql, Object[] args, int[] argTypes,
			RowMapper<T> rowMapper) throws DataAccessException {
		return getJdbcTemplate().query(sql, args, argTypes, rowMapper);
	}

	@Override
	public <T> List<T> query(String sql, Object[] args, RowMapper<T> rowMapper)
			throws DataAccessException {
		return getJdbcTemplate().query(sql, args, rowMapper);
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args)
			throws DataAccessException {
		return getJdbcTemplate().query(sql, rowMapper, args);
	}

	@Override
	public <T> T queryForObject(String sql, Object[] args, int[] argTypes,
			RowMapper<T> rowMapper) throws DataAccessException {
		return getJdbcTemplate().queryForObject(sql, args, rowMapper);
	}

	@Override
	public <T> T queryForObject(String sql, Object[] args,
			RowMapper<T> rowMapper) throws DataAccessException {
		return getJdbcTemplate().queryForObject(sql, args, rowMapper);
	}

	@Override
	public <T> T queryForObject(String sql, RowMapper<T> rowMapper,
			Object... args) throws DataAccessException {
		return getJdbcTemplate().queryForObject(sql, rowMapper, args);
	}

	@Override
	public <T> T queryForObject(String sql, Object[] args, int[] argTypes,
			Class<T> requiredType) throws DataAccessException {
		return getJdbcTemplate().queryForObject(sql, args, argTypes, requiredType);
	}

	@Override
	public <T> T queryForObject(String sql, Object[] args, Class<T> requiredType)
			throws DataAccessException {
		return getJdbcTemplate().queryForObject(sql, args, requiredType);
	}

	@Override
	public <T> T queryForObject(String sql, Class<T> requiredType,
			Object... args) throws DataAccessException {
		return getJdbcTemplate().queryForObject(sql, requiredType, args);
	}

	@Override
	public Map<String, Object> queryForMap(String sql, Object[] args,
			int[] argTypes) throws DataAccessException {
		return getJdbcTemplate().queryForMap(sql, args, argTypes);
	}

	@Override
	public Map<String, Object> queryForMap(String sql, Object... args)
			throws DataAccessException {
		return getJdbcTemplate().queryForMap(sql, args);
	}

	@Override
	public long queryForLong(String sql, Object[] args, int[] argTypes)
			throws DataAccessException {
//		return getJdbcTemplate().queryForLong(sql, args, argTypes);
		return getJdbcTemplate().queryForObject(sql, args, argTypes, Integer.class);
	}

	@Override
	public long queryForLong(String sql, Object... args)
			throws DataAccessException {
//		return getJdbcTemplate().queryForLong(sql, args);
		return getJdbcTemplate().queryForObject(sql, args, Long.class);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int queryForInt(String sql, Object[] args, int[] argTypes)
			throws DataAccessException {
		return getJdbcTemplate().queryForInt(sql, args, argTypes);
	}

	@Override
	public int queryForInt(String sql, Object... args)
			throws DataAccessException {
//		return getJdbcTemplate().queryForInt(sql, args);
		return getJdbcTemplate().queryForObject(sql, args, Integer.class);
		
	}

	@Override
	public <T> List<T> queryForList(String sql, Object[] args, int[] argTypes,
			Class<T> elementType) throws DataAccessException {
		return null;
	}

	@Override
	public <T> List<T> queryForList(String sql, Object[] args,
			Class<T> elementType) throws DataAccessException {
		return getJdbcTemplate().queryForList(sql, args, elementType);
	}

	@Override
	public <T> List<T> queryForList(String sql, Class<T> elementType,
			Object... args) throws DataAccessException {
		return getJdbcTemplate().queryForList(sql, elementType, args);
	}

	@Override
	public List<Map<String, Object>> queryForList(String sql, Object[] args,
			int[] argTypes) throws DataAccessException {
		return getJdbcTemplate().queryForList(sql, args, argTypes);
	}

	@Override
	public List<Map<String, Object>> queryForList(String sql, Object... args)
			throws DataAccessException {
		return getJdbcTemplate().queryForList(sql, args);
	}

	@Override
	public SqlRowSet queryForRowSet(String sql, Object[] args, int[] argTypes)
			throws DataAccessException {
		return getJdbcTemplate().queryForRowSet(sql, args, argTypes);
	}

	@Override
	public SqlRowSet queryForRowSet(String sql, Object... args)
			throws DataAccessException {
		return getJdbcTemplate().queryForRowSet(sql, args);
	}

	@Override
	public int update(PreparedStatementCreator psc) throws DataAccessException {
		return getJdbcTemplate().update(psc);
	}

	@Override
	public int update(PreparedStatementCreator psc, KeyHolder generatedKeyHolder)
			throws DataAccessException {
		return getJdbcTemplate().update(psc, generatedKeyHolder);
	}

	@Override
	public int update(String sql, PreparedStatementSetter pss)
			throws DataAccessException {
		return getJdbcTemplate().update(sql, pss);
	}

	@Override
	public int update(String sql, Object[] args, int[] argTypes)
			throws DataAccessException {
		return getJdbcTemplate().update(sql, args, argTypes);
	}

	@Override
	public int update(String sql, Object... args) throws DataAccessException {
		return getJdbcTemplate().update(sql, args);
	}

	@Override
	public int[] batchUpdate(String sql, BatchPreparedStatementSetter pss)
			throws DataAccessException {
		return getJdbcTemplate().batchUpdate(sql, pss);
	}

	@Override
	public int[] batchUpdate(String sql, List<Object[]> batchArgs) {
		return getJdbcTemplate().batchUpdate(sql, batchArgs);
	}

	@Override
	public int[] batchUpdate(String sql, List<Object[]> batchArgs,
			int[] argTypes) {
		return getJdbcTemplate().batchUpdate(sql, batchArgs, argTypes);
	}

	@Override
	public <T> int[][] batchUpdate(String sql, Collection<T> batchArgs,
			int batchSize, ParameterizedPreparedStatementSetter<T> pss) {
		return getJdbcTemplate().batchUpdate(sql, batchArgs, batchSize, pss);
	}

	@Override
	public <T> T execute(CallableStatementCreator csc,
			CallableStatementCallback<T> action) throws DataAccessException {
		return getJdbcTemplate().execute(csc, action);
	}

	@Override
	public <T> T execute(String callString, CallableStatementCallback<T> action)
			throws DataAccessException {
		return getJdbcTemplate().execute(callString, action);
	}

	@Override
	public Map<String, Object> call(CallableStatementCreator csc,
			List<SqlParameter> declaredParameters) throws DataAccessException {
		return getJdbcTemplate().call(csc, declaredParameters);
	}
}