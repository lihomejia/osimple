package cn.com.norming.num.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.norming.core.db.dao.CommonDao;
import cn.com.norming.core.web.SpringContextHelper;

public class NumberCustomUtil {
	public static final String TYPE_PREFIX = "TYPE_";
	
	private static Map<String, List<Map<String, Object>>> numOptions = new HashMap<String, List<Map<String,Object>>>();
	
	public static List<Map<String, Object>> getNumOptionFromCache(String type){
		return numOptions.get(type);
	}
	
	public static List<Map<String, Object>> getNumOptionFromDb(String type){
		String querySql = "select ASNOPTD_LINENUM,ASNOPTD_SEGTYPE,ASNOPTD_DATADEFAULT,ASNOPTD_SOURCE,ASNOPTD_DATAFIELD,ASNOPTD_DATEFMT,ASNOPTD_SEPARATOR,ASNOPTD_NUMLENGTH from ASNOPTD where ASNOPTD_MODTYPE = ? order by ASNOPTD_LINENUM";
		CommonDao commonDao = SpringContextHelper.getBean(CommonDao.BEAN_NAME);
		List<Map<String, Object>> numOptionL =  commonDao.findDataList(querySql, new String[]{type});
		
		numOptions.put(TYPE_PREFIX + type, numOptionL);
		
		return numOptionL;
	}
	
	public static void refresh() {
		numOptions.clear();
	}
}
