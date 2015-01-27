package com.norming.num.impl;

import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.norming.dao.CommonDao;
import com.norming.num.INumber;
import com.norming.num.domain.Asnopt;
import com.norming.num.util.NumberSingleUtil;
import com.norming.spring.context.SpringContextHolder;
import com.norming.util.DateUtil;
import com.norming.util.NumberUtil;
import com.norming.util.StringUtil;


public abstract class AbstractNumberSingle implements INumber {
	
	private String type;

	protected Integer count;
	
	public AbstractNumberSingle(String type) {
		this.type = type;
	}
	
	public abstract String getTable();
	public abstract String getField();
	public String addwhere() {return null;};
	
	@Override
	public synchronized String getAndIncrease(Map<String, Object> params) {
		Asnopt nopt = NumberSingleUtil.getNumOptionFromCache(this.type);
		if (nopt == null || count == null) {
			if (nopt == null) {
				nopt = NumberSingleUtil.getNumOptionFromDb(this.type);
			}
			this.readFromDb();
		}
		
		StringBuffer ret = new StringBuffer();
		ret.append(nopt.getPrefix());
		ret.append(nopt.getSeparator());
		if (nopt.isUsedate()) {
			ret.append(DateUtil.format(new Date(), nopt.getDatefmt()));
			ret.append(nopt.getSeparator());
		}
		ret.append(StringUtil.leftPad(String.valueOf(++count), nopt.getNumlength(), "0"));
		return ret.toString();
	}

	public void readFromDb() {
		
		Asnopt nopt = NumberSingleUtil.getNumOptionFromCache(this.type);
		
		StringBuffer like = new StringBuffer();
		like.append(nopt.getPrefix());
		like.append(nopt.getSeparator());
		if (nopt.isUsedate()) {
			like.append(StringUtil.leftPad("", nopt.getDatefmt().length(), "_"));
			like.append(nopt.getSeparator());
		}
		like.append(StringUtil.leftPad("", nopt.getNumlength(), "_"));
		
		StringBuffer sql = new StringBuffer();
		sql
			.append("select max(").append(getField()).append(") AS DOCID")
			.append(" from ").append(getTable())
			.append(" where ").append(getField()).append(" like '").append(like).append("'");
		;
		if (addwhere() != null) {
			sql.append(" and ").append(addwhere());
		}

		CommonDao commonDao = SpringContextHolder.getBean(CommonDao.BEAN_NAME);
		Map<?, ?> map = commonDao.queryForMap(sql.toString());
		Object oDocid = map.get("DOCID");
		
		if (oDocid == null) {
			count = 0;
			return;
		}
		
		String docid = oDocid.toString();
		
		Pattern p = Pattern.compile("\\d{" + nopt.getNumlength() + "}$");
		Matcher m = p.matcher(docid);
		
		if (m.find()) {
			count = NumberUtil.toInt(m.group());
		} else {
			count = 0;
		}
	}
}