package com.norming.num.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.norming.dao.CommonDao;
import com.norming.num.INumber;
import com.norming.num.util.NumberCustomUtil;
import com.norming.spring.context.SpringContextHolder;
import com.norming.util.DateUtil;
import com.norming.util.NumberUtil;
import com.norming.util.ObjectUtil;
import com.norming.util.StringUtil;

public abstract class AbstractMainNumberCustom implements INumber {
	private String type;
	
	private Map<String, Integer> numM = new HashMap<String, Integer>();
	
	private static final String CODESTR = "CODESTR";
	
	private static final String SERIALNUM = "SERIALNUM";
	
	private static final String SERIALNUMADD = "SERIALNUMADD";
	
	public abstract String getTable();
	public abstract String getField();
	
	public AbstractMainNumberCustom(String type){
		this.type = type;
	}
	
	@Override
	public String getAndIncrease(Map<String, Object> params){
		
		List<Map<String, Object>> optdL = NumberCustomUtil.getNumOptionFromCache(NumberCustomUtil.TYPE_PREFIX+type);
		
		if(optdL == null){
			optdL = NumberCustomUtil.getNumOptionFromDb(type);
		}
		
		Map<String, String> codeM = codeRule(optdL, params);

		String codeStr = codeM.get(CODESTR);
			
		if(numM == null){
			numM = new HashMap<String, Integer>();
		}
		if(!numM.containsKey(NumberCustomUtil.TYPE_PREFIX + type + "_" + codeStr)){
			this.readFromDb(codeM);
		}
		
		int count = numM.get(NumberCustomUtil.TYPE_PREFIX + type + "_" + codeStr);
		numM.put(NumberCustomUtil.TYPE_PREFIX + type + "_" + codeStr, ++count);
		
		String serialNo = StringUtil.leftPad(String.valueOf(count), codeM.get(SERIALNUM).length(), "0");
		
		return codeM.get(CODESTR).replace(codeM.get(SERIALNUM), serialNo);
	}
	
	public void readFromDb(Map<String, String> codeM){
		StringBuffer querySql = new StringBuffer();
		querySql.append("select max(").append(getField()).append(") AS DOCID from ")
			.append(getTable()).append(" where ").append(getField()).append(" like '").append(processChar(codeM.get(CODESTR))).append("'");
		CommonDao commonDao = SpringContextHolder.getBean(CommonDao.BEAN_NAME);
		Map<String, Object> map = commonDao.queryForMap(querySql.toString());
		Object oDocid = map.get("DOCID");
		
		if (oDocid == null) {
			numM.put(NumberCustomUtil.TYPE_PREFIX + type + "_" + codeM.get(CODESTR), 0);
			return;
		}
		
		String docid = oDocid.toString();
		
		int serialNoAddress = NumberUtil.toInt(codeM.get(SERIALNUMADD));
		
		int count = NumberUtil.toInt(docid.substring(serialNoAddress, serialNoAddress + codeM.get(SERIALNUM).length()));
		
		numM.put(NumberCustomUtil.TYPE_PREFIX + type + "_" + codeM.get(CODESTR), count);
	}
	
	private String processChar(String str) {
		if(str != null && !"".equals(str.trim())){
			if(str.contains("[") ){
				str = str.replace("[", "[[]");
			}
			if(str.contains("%")){
				str = str.replace("%", "[%]");
			}
		}else{
			str="";
		}
		
		return str;
	}
	
	private Map<String, String> codeRule(List<Map<String, Object>> optdL, Map<String, Object> params) {
		Map<String, String> codeM = new HashMap<String, String>();

		Map<String, Object> dataM = new HashMap<String, Object>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(ObjectUtil.toString(params.get("PMPROJECT_ESTDATE"), ""));
		} catch (Exception e) {
			
		}
		for (Map<String, Object> m : optdL) {
			// segType 0:日期,1:手工输入,2:基础表,3:关联表,4:Lookup,5:流水号
			int segType = NumberUtil.toInt(m.get("ASNOPTD_SEGTYPE"));
			String source = ObjectUtil.toString(m.get("ASNOPTD_SOURCE"), "");
			if (segType == 0) {
				m.put("ASNOPTD_DATADEFAULT", sdf.format(date));
			}else if(segType == 1) {
				String enterStr = ObjectUtil.toString(params.get("ASNOPTD_DATADEFAULT"),"");
				if(!"".equals(enterStr.trim())){
					m.put("ASNOPTD_DATADEFAULT", enterStr);
				}
			}else if (segType == 2 || segType == 3) {
				m.put("ASNOPTD_DATADEFAULT", params.get(source));
			} else if (segType == 5) {
				int nLen = Integer.parseInt(ObjectUtil.toString(m.get("ASNOPTD_NUMLENGTH"), "0"));
				String def = "";
				for (int j = 0; j < nLen; j++) {
					def += "_";
				}
				m.put("ASNOPTD_DATADEFAULT", def);
			}
			dataM.put(ObjectUtil.toString(m.get("ASNOPTD_LINENUM"), ""), m.get("ASNOPTD_SEGTYPE") + "-" + m.get("ASNOPTD_DATADEFAULT"));
		}
		
		String codeStr = "";
		String serialNo = "";
		int serialNoAddress = 0;
		for (Map<String, Object> m : optdL) {
			String _value = ObjectUtil.toString(dataM.get(m.get("ASNOPTD_LINENUM")+""), "");
			String type, tValue = "";
			if (_value != null && _value.length() > 0) {
				type = _value.substring(0, 1);
				tValue = _value.substring(2);
				if (type.equals("0")) {
					String dtFT = ObjectUtil.toString(m.get("ASNOPTD_DATEFMT"), "");
					try {
						tValue = DateUtil.format(sdf.parse(tValue), dtFT);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} else if (type.equals("5")) {
					serialNo = tValue;
					serialNoAddress = codeStr.length();
				}
			}
			codeStr += tValue;
		}
		codeM.put(CODESTR, codeStr);
		codeM.put(SERIALNUM, serialNo);
		codeM.put(SERIALNUMADD, ObjectUtil.toString(serialNoAddress));
		
		return codeM;
	}
	
}