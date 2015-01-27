package com.norming.num.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.norming.dao.CommonDao;
import com.norming.num.domain.Asnopt;
import com.norming.spring.context.SpringContextHolder;
import com.norming.util.BooleanUtil;
import com.norming.util.NumberUtil;
import com.norming.util.ObjectUtil;

public class NumberSingleUtil {
	
	private static Map<String, Asnopt> numOptions = new HashMap<String, Asnopt>();
	
	public static Asnopt getNumOptionFromCache(String type) {
		return numOptions.get(type);
	}
	
	public static Asnopt getNumOptionFromDb(String type) {
		CommonDao commonDao = SpringContextHolder.getBean(CommonDao.BEAN_NAME);
		
		String sql = new StringBuffer()
			.append(" select ASNOPT_PREFIX, ASNOPT_USEDATE, ASNOPT_DATEFMT, ASNOPT_NUMLENGTH, ASNOPT_SEPARATOR")
			.append(" from ASNOPT ")
			.append(" where ASNOPT_MODTYPE='").append(type).append("'")
			.toString()
		;
		List<Map<String, Object>> numOptionList = commonDao.queryForList(sql);
		
		if (numOptionList.size() == 0) {
			throw new RuntimeException("...");
		}
		Map<String, Object> numOption = numOptionList.get(0);
		Asnopt asnopt = new Asnopt();
		asnopt.setPrefix(	ObjectUtil.toString( numOption.get("ASNOPT_PREFIX")));
		asnopt.setUsedate(	BooleanUtil.toBoolean(ObjectUtil.toString(numOption.get("ASNOPT_USEDATE"))));
		asnopt.setDatefmt(	ObjectUtil.toString( numOption.get("ASNOPT_DATEFMT")));
		asnopt.setNumlength(NumberUtil.toInt(    numOption.get("ASNOPT_NUMLENGTH")));
		asnopt.setSeparator(ObjectUtil.toString( numOption.get("ASNOPT_SEPARATOR")));
		
		numOptions.put(type, asnopt);
		
		return asnopt;
	}
	
	public static void refresh() {
		numOptions.clear();
	}
}
