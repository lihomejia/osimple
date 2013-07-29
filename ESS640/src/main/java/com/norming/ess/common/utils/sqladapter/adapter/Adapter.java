package com.norming.ess.common.utils.sqladapter.adapter;
/**
 * @author LiRui
 * @date Aug 2,2012
 * */
public class Adapter {
	public String toMySqlQuerySql(String finalSql,String start,String limit){
		finalSql  = finalSql.toUpperCase();
		int START = Integer.valueOf(start);
		int LIMIT = Integer.valueOf(limit);
		StringBuffer pagingSql = new StringBuffer();
		pagingSql.append(finalSql);
		pagingSql.append(" limit ");
		pagingSql.append(START);
		pagingSql.append(" , ");
		pagingSql.append(START+LIMIT);
		return pagingSql.toString();	
	}
	public String toOracleQuerySql(String finalSql,String start,String limit){
		finalSql  = finalSql.toUpperCase();
		int START = Integer.valueOf(start);
		int LIMIT = Integer.valueOf(limit);
		StringBuffer pagingSql = new StringBuffer();
		pagingSql.append(" SELECT * FROM ( SELECT ROW_.*, ROWNUM ROWNUM_FROM FROM ( ");
		pagingSql.append(finalSql);
		pagingSql.append(" ) ROW_ WHERE ROWNUM <= ");
		pagingSql.append(START+LIMIT);
		pagingSql.append(") WHERE ROWNUM > ");
		pagingSql.append(START);
		return pagingSql.toString();
	}
	public String toSqlServerQuerySql(String finalSql,String start,String limit){
			finalSql  = finalSql.toUpperCase();
			int START = Integer.valueOf(start);
			int LIMIT = Integer.valueOf(limit);
			String orderBy = finalSql.substring(finalSql.lastIndexOf("ORDER BY"), finalSql.length());
			String tempSql = finalSql.substring(0,  finalSql.indexOf("ORDER BY")).replace("SELECT", "");
			StringBuffer pagingSql = new StringBuffer();
			pagingSql.append(" SELECT * FROM(");
			pagingSql.append(" SELECT ROW_NUMBER() OVER (").append(orderBy).append(") AS ROWNUMBER, ");
			pagingSql.append(tempSql);
			pagingSql.append(" ) t ");
			pagingSql.append(" WHERE ROWNUMBER > ").append(START).append(" AND ");
			pagingSql.append(" ROWNUMBER <= ").append(START+LIMIT);
			return pagingSql.toString();
	}
	
	public static void main(String[] args){
		StringBuffer finalSql = new StringBuffer();
		finalSql.append(" SELECT * FROM TEST_TABLE ORDER BY TEST_ID");
		System.out.println(new Adapter().toMySqlQuerySql    (finalSql.toString(), "0", "20"));
		System.out.println(new Adapter().toOracleQuerySql   (finalSql.toString(), "20","20"));
		System.out.println(new Adapter().toSqlServerQuerySql(finalSql.toString(), "0", "20"));
	}
}