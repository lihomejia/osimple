package cn.com.norming.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.ObjectUtils;


public class DateUtil {
	
	/**
	 * 系统默认的DateFormay格式 
	 */
	public static final String DEF_PATTERN = "yyyy-MM-dd";
	
	public static SimpleDateFormat DEF_SDF = new SimpleDateFormat(DEF_PATTERN);
	
	public static String format(Date date) {
		if (date == null) return "";
		return DEF_SDF.format(date);
	}
	
	public static String format(Object date) {
		if (date instanceof Date) return format((Date) date);
		return "";
	}
	
	public static Date parse(String date) {
		try {
			return DEF_SDF.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	public static Date parse(Object date) {
		return parse(ObjectUtils.toString(date));
	}
	
	
}
