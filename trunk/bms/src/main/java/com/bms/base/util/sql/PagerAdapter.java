package com.bms.base.util.sql;

public interface PagerAdapter {
	
	
	String toPagerSql(String sql, int start, int count);
}
