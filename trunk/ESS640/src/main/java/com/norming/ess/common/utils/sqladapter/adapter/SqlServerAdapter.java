/**
 * Copyright (C) Norming Information Technology Co.,Ltd. 2012. All 
 * rights reserved.
 *
 * This software is covered by the license agreement between the end user and
 * Norming Information Technology Co.,LTD., and may be used and copied 
 * only in accordance with the terms of the said agreement.
 * 
 * Norming Information Science Co.,LTD. assumes no responsibility or 
 * liability for any errors or inaccuracies in this software, 
 * or any consequential, incidental or indirect damage arising out of the use 
 * of the software.
 */
package com.norming.ess.common.utils.sqladapter.adapter;
/**
 * MSSqlServer
 * @author lirui
 * @date Aug 2,2012
 * */
public class SqlServerAdapter {
	
	public String toSqlServerQuerySql(String finalSql,String start,String limit){
		
		finalSql  = finalSql.toUpperCase();
		int START = Integer.valueOf(start);
		int LIMIT = Integer.valueOf(limit);
		String orderBy = finalSql.substring(finalSql.lastIndexOf("ORDER BY"), finalSql.length());
		String tempSql = finalSql.substring(0,  finalSql.indexOf("ORDER BY")).replaceFirst("SELECT", "");
		StringBuffer pagingSql = new StringBuffer();
		pagingSql.append(" SELECT * FROM(");
		pagingSql.append(" SELECT ROW_NUMBER() OVER (").append(orderBy).append(") AS ROWNUMBER, ");
		pagingSql.append(tempSql);
		pagingSql.append(" ) t ");
		pagingSql.append(" WHERE ROWNUMBER > ").append(START).append(" AND ");
		pagingSql.append(" ROWNUMBER <= ").append(START+LIMIT);
		
		return pagingSql.toString();
	}
}
