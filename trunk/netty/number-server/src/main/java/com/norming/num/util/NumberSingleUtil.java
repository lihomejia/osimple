package com.norming.num.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.norming.core.db.dao.CommonDao;
import com.norming.core.web.SpringContextHelper;
import com.norming.num.domain.Asnopt;

public class NumberSingleUtil {
	
	private static Map<String, Asnopt> numOptions = new HashMap<String, Asnopt>();
	
	public static Asnopt getNumOptionFromCache(String type) {
		return numOptions.get(type);
	}
	
	public static Asnopt getNumOptionFromDb(String type) {
		CommonDao commonDao = SpringContextHelper.getBean(CommonDao.BEAN_NAME);
		
		String sql = new StringBuffer()
			.append(" select ASNOPT_PREFIX, ASNOPT_USEDATE, ASNOPT_DATEFMT, ASNOPT_NUMLENGTH, ASNOPT_SEPARATOR")
			.append(" from ASNOPT ")
			.append(" where ASNOPT_MODTYPE='").append(type).append("'")
			.toString()
		;
		List<?> numOptionList = commonDao.findDataList(sql);
		
		if (numOptionList.size() == 0) {
			throw new RuntimeException("...");
		}
		Map<?, ?> numOption = (Map<?, ?>) numOptionList.get(0);
		Asnopt asnopt = new Asnopt();
		asnopt.setPrefix(	NumUtil.toString( numOption.get("ASNOPT_PREFIX")));
		asnopt.setUsedate(	NumUtil.toBoolean(numOption.get("ASNOPT_USEDATE")));
		asnopt.setDatefmt(	NumUtil.toString( numOption.get("ASNOPT_DATEFMT")));
		asnopt.setNumlength(NumUtil.toInt(    numOption.get("ASNOPT_NUMLENGTH")));
		asnopt.setSeparator(NumUtil.toString( numOption.get("ASNOPT_SEPARATOR")));
		
		numOptions.put(type, asnopt);
		
		return asnopt;
	}
	
	public static void refresh() {
		numOptions.clear();
	}
}
