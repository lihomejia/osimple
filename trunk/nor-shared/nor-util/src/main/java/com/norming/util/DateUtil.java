package com.norming.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author lh.jia Created on 2015-01-26
 * 
 * @see org.apache.commons.lang3.time.DateUtils
 * 
 */
public class DateUtil extends org.apache.commons.lang3.time.DateUtils {

	/** PATTERN yyyy-MM-dd HH:mm:ss */
	public static final String DATETIME_DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/** pattern yyyy-MM-dd */
	public static final String DATE_SAMPLE_PATTERN = "yyyy-MM-dd";

	/** pattern yyyyMMdd */
	public static final String DATE_NUMBER_PATTERN = "yyyyMMdd";

	/** pattern HH:mm */
	public static final String TIME_DEFAULT_PATTERN = "HH:mm";

	/** pattern HH:mm:ss */
	public static final String TIME_SAMPLE_PATTERN = "HH:mm:ss";

	/** patterns */
	public static final String[] DATE_PATTERNS = new String[] { "yyyy-MM-dd",
			"yyyy/MM/dd", "MM/dd/yyyy", "dd/MM/yyyy", "dd.MM.yyyy" };

	/**
	 * 转换格式为yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return String
	 * @author ys.wang
	 * @date Mar 28, 2013
	 */
	public static String format(Date date) {
		return format(date, DATETIME_DEFAULT_PATTERN);
	}

	
	/**
	 * 将日期类型转换为数据库的日期类型
	 * 
	 * @author xudong.zhang
	 * @date 2014-5-15
	 * @param date
	 * @return
	 */
	public static java.sql.Date parse2SqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}

	
	/**
	 * 将yyyy-mm-dd的字符串日期转换为数据库的日期类型
	 * 
	 * @author xudong.zhang
	 * @date 2014-5-15
	 * @param date
	 * @return
	 */
	public static java.sql.Date parse2SqlDate(String date) {
		return java.sql.Date.valueOf(date);
	}

	
	/**
	 * 获得当前数据类型的日期
	 * 
	 * @author xudong.zhang
	 * @date 2014-5-15
	 * @return
	 */
	public static java.sql.Date newSqlDate() {
		return new java.sql.Date(new Date().getTime());
	}
	

	/**
	 * 获取当前时间戳
	 * 
	 * @author xudong.zhang
	 * @date 2014-5-15
	 * @return
	 */
	public static Timestamp newTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	
	/**
	 * 转换格式为yyyy-MM-dd
	 * 
	 * @author xudong.zhang
	 * @date 2013-10-21
	 * @param date
	 * @return String
	 */
	public static String format2SampleDate(Date date) {
		return format(date, DATE_SAMPLE_PATTERN);
	}

	
	/**
	 * 将日期类型的对象转换格式为yyyy-MM-dd
	 * 
	 * @author xudong.zhang
	 * @date 2013-10-21
	 * @param obj
	 * @return String
	 */
	public static String format2SampleDate(Object obj) {
		if (obj == null) {
			return null;
		}
		if (obj instanceof Date) {
			Date date = (Date) obj;
			return format2SampleDate(date);
		}
		return null;
	}
	

	/**
	 * 将格式为yyyy-MM-dd格式字符串转换为Date
	 * 
	 * @author xudong.zhang
	 * @date 2013-10-18
	 * @param str
	 * @return Date
	 */
	public static Date parseDate(String str) {
		try {
			return parseDate(str, DATE_SAMPLE_PATTERN);
		} catch (ParseException e) {
			return null;
		}
	}

	
	/**
	 * 
	 * @param str
	 * @param fromPattern
	 * @param toPattern
	 * @return
	 * @author ys.wang
	 * @date Aug 17, 2012
	 * @return String
	 */
	public static String format(String str, String fromPattern, String toPattern) {
		String res = "";
		String[] patterns = new String[] { fromPattern };
		Date date = null;
		try {
			date = parseDate(str, patterns);
		} catch (ParseException e) {
			return null;
		}
		if (date != null) {
			res = format(date, toPattern);
		}
		return res;
	}

	
	/**
	 * <b>按照指定格式转换字符串</b>
	 * 
	 * @param date
	 * @param pattern
	 * @return created by:ys.wang created time: Aug 14, 2012 10:20:50 AM
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
		return dateformat.format(date);
	}

	
	/**
	 * 转换格式为yyyy-MM-dd
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date parse2SampleDate(String date) {
		try {
			return new SimpleDateFormat(DATE_SAMPLE_PATTERN).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	
	/**
	 * 转换格式为yyyy-MM-dd
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date parse2SampleDatetime(String date) {
		try {
			return new SimpleDateFormat(DATETIME_DEFAULT_PATTERN).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	
	/**
	 * 转换格式为yyyy-MM-dd
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date parse2SampleDate(Object date) {
		return parse2SampleDate(ObjectUtil.toString(date));
	}

	
	/**
	 * 转换格式为yyyy-MM-dd
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date parse2SampleDatetime(Object date) {
		return parse2SampleDatetime(ObjectUtil.toString(date));
	}
	

	/**
	 * Get Current Date
	 * 
	 * @return String
	 * @author ys.wang
	 * @date Jan 28, 2013
	 */
	public static String getCurrentDate() {
		return format(new Date(), DATE_SAMPLE_PATTERN);
	}
	

	/**
	 * 1900-01-01 00:00:00
	 * 
	 * @date 2013-11-19
	 * @return
	 */
	public static Date getDbDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1900, 0, 1);
		return clearTime(calendar.getTime());
	}

	
	/**
	 * 获得当年的第一天
	 * 
	 * @author xudong.zhang
	 * @date 2013-11-16
	 * @return
	 */
	public static Date getCurrentYearFirstDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), 0, 1);
		return clearTime(calendar.getTime());
	}

	
	/**
	 * Get Current Year
	 * 
	 * @return int
	 * @author ys.wang
	 * @date 2013-11-13
	 */
	public static int getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.YEAR);
	}
	

	/**
	 * Get Current Date Time
	 * 
	 * @return String
	 * @author ys.wang
	 * @date Jan 28, 2013
	 */
	public static String getCurrentDateTime() {
		return format(new Date(), DATETIME_DEFAULT_PATTERN);
	}

	
	/**
	 * Get Current Time HH:mm:ss
	 * 
	 * @author xudong.zhang
	 * @date 2013-10-23
	 * @return TIME_SAMPLE_PATTERN
	 */
	public static String getCurrentTime() {
		return format(new Date(), TIME_SAMPLE_PATTERN);
	}

	
	/**
	 * Get Current Time HH:mm
	 * 
	 * @author xudong.zhang
	 * @date 2013-10-23
	 * @return TIME_SAMPLE_PATTERN
	 */
	public static String getCurrentTime2() {
		return format(new Date(), TIME_DEFAULT_PATTERN);
	}
	

	/**
	 * 计算两个日期之间的天数＋1,包含开始和结束的这两天.
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return created by:ys.wang created time: Aug 14, 2012 10:36:52 AM
	 */
	public static int daysOfTwoDate(Date beginDate, Date endDate) {
		return (int) ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY) + 1;
	}

	
	/**
	 * 去掉时间
	 * 
	 * @param date
	 * @return Date
	 * @author ys.wang
	 * @date Feb 27, 2013
	 */
	public static Date clearTime(Date date) {
		if (date == null) {
			return null;
		}
		return truncate(date, Calendar.DATE);
	}

	
	/**
	 * 判断一个日期是否介于 两个日期之间 ，包含边界
	 * 
	 * @param startDate
	 *            起始日期
	 * @param endDate
	 *            结束日期
	 * @param date
	 *            要测试的日期
	 * @param field
	 *            精确的field 比如 Calendar.YEAR Calendar.Date
	 * @return boolean
	 * @author ys.wang
	 * @date Feb 27, 2013
	 */
	public static boolean isBeteen(Date startDate, Date endDate, Date date,
			int field) {
		int res1 = truncatedCompareTo(date, startDate, field);
		int res2 = truncatedCompareTo(endDate, date, field);
		if (res1 >= 0 && res2 >= 0) {
			return true;
		}
		return false;
	}

	
	/**
	 * 获取本周一的日期
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date findMonDayOfWeek(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int amount = Calendar.MONDAY - calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.DATE, amount);

		return calendar.getTime();
	}

	
	/**
	 * 获取下周一的日期
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date findMonDayOfNextWeek(Date date) {

		Date monday = findMonDayOfWeek(date);

		return addDays(monday, 7);
	}
}