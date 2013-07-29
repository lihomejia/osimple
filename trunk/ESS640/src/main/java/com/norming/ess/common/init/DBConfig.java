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
package com.norming.ess.common.init;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Init dbType for sqlAdapter.
 * 
 * @return dbType Like mysql , oracle ,sqlserver
 * @author lirui
 * @date   Aug 6,2012
 * */
public class DBConfig {
	/**
	 * 
	 * @param  jdbc.dbtype
	 * @author lirui
	 * @date   Aug 7,2012
	 * 
	 * */
	public String getDBType(){
		String dbType = null;
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties(); 
		try{ 
			properties.load(inputStream);
			dbType = properties.getProperty("jdbc.dbtype");
		}catch(IOException ioe) { 
			ioe.printStackTrace(); 
		}finally{
			try {
				if(inputStream!=null){
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return dbType;
	}
}
