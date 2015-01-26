package com.norming.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author lh.jia Created on 2015-01-26
 * 
 * @see org.apache.commons.lang3.StringUtils
 * 
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils {

	/**
	 * StringBuilder的初始化大小,设置的大点,
	 */
	public static final int SB_BUF_SIZE = 1000;
	/** A table of hex digits */
	private static Pattern numPattern = Pattern.compile("(\\{)(\\d+)(\\})");

	/**
	 * 判断是否是一个"无意义/无效"的web值,null,空字符串或"undefined","null"
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isBlankWebString(String value) {
		return isBlank(value) || "undefined".equals(value) || "null".equals(value);
	}

	/**
	 * <p>
	 * Returns either the passed in String, or if the String is web blank, an
	 * empty String ("").
	 * </p>
	 * 
	 * @param value
	 * @return
	 */
	public static String defaultWebBlankString(String value) {
		return defaultWebBlankString(value, EMPTY);
	}

	/**
	 * <b>如果是空 返回默認值</b>
	 * 
	 * @param value
	 * @param defaults
	 * @return created by:zhiqiang.hao created time: Aug 16, 2012 2:27:59 PM
	 */
	public static String defaultWebBlankString(String value, String defaults) {
		return isBlankWebString(value) ? defaults : value;
	}

	/**
	 * format a string,
	 * 
	 * <pre>
	 * like this: 
	 * format("the {0} {1} jumps over the {2} {3}", "red", "fox", "gray", "dog")
	 *  get the result, "the red fox jumps over the gray dog"
	 * </pre>
	 * 
	 * @param src
	 *            源字符串,里面可以包含有{0}这样的待替换单元.
	 * @param pars
	 *            要替换的内容,多个字符串,从序号0开始计算.
	 * @return
	 */
	public static String format(String src, Object... pars) {
		if (isEmpty(src)) {
			return "";
		}

		StringBuilder sb = new StringBuilder(SB_BUF_SIZE);
		Matcher matcher = numPattern.matcher(src);
		int pos = 0;

		while (matcher.find(pos)) {
			int count = matcher.groupCount();

			sb.append(src.substring(pos, matcher.start(1)));
			int num = Integer.parseInt(src.substring(matcher.start(2),
					matcher.end(2)));
			if (pars.length >= num + 1) {
				sb.append(pars[num]);
			} else {
				sb.append('{').append(num).append('}');
			}

			pos = matcher.end(count);
		}

		sb.append(src.substring(pos));

		return sb.toString();
	}

	
	/**
	 * 在字符串中查询子字符串,获得,则返回左边部分,否则,返回null.不区分大小写.
	 * 
	 * @author lh.jia
	 * 
	 * @param value
	 * @param sep
	 * @return
	 */
	public static String stringLeft(String value, String sep) {
		int pos = value.toLowerCase().indexOf(sep.toLowerCase());
		return pos == -1 ? null : value.substring(0, pos);
	}

	/**
	 * 在字符串中查询子字符串,获得,则返回左边部分,否则,返回null.从右边开始查询.不区分大小写.
	 * 
	 * @author lh.jia
	 * 
	 * @param value
	 * @param sep
	 * @return
	 */
	public static String stringLeftBack(String value, String sep) {
		int pos = value.toLowerCase().lastIndexOf(sep.toLowerCase());
		return pos == -1 ? null : value.substring(0, pos);
	}

	/**
	 * 在字符串中查询子字符串,获得,则返回右边部分,否则,返回null.不区分大小写.
	 * 
	 * @author lh.jia
	 * 
	 * @param value
	 * @param sep
	 * @return
	 */
	public static String stringRight(String value, String sep) {
		int pos = value.toLowerCase().indexOf(sep.toLowerCase());
		return pos == -1 ? null : value.substring(pos + sep.length());
	}

	/**
	 * 在字符串中从右侧向左侧查询子字符串,命中,则返回右边部分,否则,返回null.不区分大小写.
	 * 
	 * @author lh.jia
	 * 
	 * @param value
	 * @param sep
	 * @return
	 */
	public static String stringRightBack(String value, String sep) {
		int pos = value.toLowerCase().lastIndexOf(sep.toLowerCase());
		return pos == -1 ? null : value.substring(pos + sep.length());
	}
}