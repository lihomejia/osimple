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
package com.norming.ess.common.utils.sqladapter;

import com.norming.ess.common.Constants;
import com.norming.ess.common.init.AppContext;
import com.norming.ess.common.utils.sqladapter.adapter.MySqlAdapter;
import com.norming.ess.common.utils.sqladapter.adapter.OracleAdapter;
import com.norming.ess.common.utils.sqladapter.adapter.SqlServerAdapter;

/**
 * Sql Adapter
 * support : MySql Oracel MSSqlServer
 * @author lirui
 * @date   Aug 2,2012
 * */
public class SqlAdapter {
	/**
	 *    To Paging Sql
	 *    
	 * @param  String finalSql
	 * @param  String start
	 * @param  String limit
	 * @return finalSql 
	 * @author lirui
	 * @date   Aug 2.2012
	 * */
	public String toPagingFinalSql(String finalSql,String start,String limit){
		
		String DB_TYPE = AppContext.getDBType();
		if(Constants.ORACLE.equals(DB_TYPE)){
			return new OracleAdapter().toOracleQuerySql(finalSql, start, limit);
		}else if(Constants.SQLSERVER.equals(DB_TYPE)){
			return new SqlServerAdapter().toSqlServerQuerySql(finalSql, start, limit);
		}else if(Constants.MYSQL.equals(DB_TYPE)){
			return new MySqlAdapter().toMySqlQuerySql(finalSql, start, limit);
		}
		return null; 
	}
	
	/**
	 *   transfer database key
	 *    
	 * @param  String key
	 * @return transfer key 
	 * @author tongtong.yang
	 * @date   2013.02.20
	 * */
	public static String transferDbKey(String key){
		
		String DB_TYPE = AppContext.getDBType();
		if(Constants.ORACLE.equals(DB_TYPE)){
			return "\""+key+"\"";
		}else if(Constants.SQLSERVER.equals(DB_TYPE)){
			return "\""+key+"\"";
		}else if(Constants.MYSQL.equals(DB_TYPE)){
			return key;
		}
		return key; 
	}
}
