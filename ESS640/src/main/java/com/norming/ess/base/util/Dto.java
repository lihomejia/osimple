package com.norming.ess.base.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Dto extends Map<String, Object> {
	
	String getString(String key);
	
	<T> List<T> getList(String key);
	
	int getInt(String key);
	
	double getDouble(String key);
	
	BigDecimal getDecimal(String key);
	
	Date getDate(String key);
	
}