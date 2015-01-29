package com.norming.num.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.norming.dao.CommonDao;
import com.norming.spring.context.SpringContextHolder;
import com.norming.util.LocalCompContext;

public class NumberCustomUtil {
	public static final String TYPE_PREFIX = "TYPE_";
	
	private static Map<String, Map<String, List<Map<String, Object>>>> numOptions = new HashMap<>();
	
	
	private static Map<String, List<Map<String, Object>>> getCompNumOptions() {
		String comp = LocalCompContext.getUserCompany();
		
		Map<String, List<Map<String, Object>>> compNumOptions = numOptions.get(comp);
		
		if (compNumOptions == null) {
			compNumOptions = new HashMap<>();
			numOptions.put(comp, compNumOptions);
		}
		return compNumOptions;
	}
	
	public static List<Map<String, Object>> getNumOptionFromCache(String type){
		return getCompNumOptions().get(type);
	}
	
	public static List<Map<String, Object>> getNumOptionFromDb(String type){
		String querySql = "select ASNOPTD_LINENUM,ASNOPTD_SEGTYPE,ASNOPTD_DATADEFAULT,ASNOPTD_SOURCE,ASNOPTD_DATAFIELD,ASNOPTD_DATEFMT,ASNOPTD_SEPARATOR,ASNOPTD_NUMLENGTH from ASNOPTD where ASNOPTD_MODTYPE = ? order by ASNOPTD_LINENUM";
		CommonDao commonDao = SpringContextHolder.getBean(CommonDao.BEAN_DYNAMIC);
		List<Map<String, Object>> numOptionL =  commonDao.queryForList(querySql, new Object[]{type});
		
		getCompNumOptions().put(TYPE_PREFIX + type, numOptionL);
		
		return numOptionL;
	}
	
	public static void refresh() {
		numOptions.clear();
	}
}
