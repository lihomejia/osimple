package cn.com.norming.num.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NumUtil {
	public static int toInt(Object o) {
		return toInt(o, 0);
	}
	
	public static int toInt(Object o, int def) {
		try {
			return Integer.parseInt(toString(o));
		} catch (NumberFormatException e) {
			return def;
		}
	}
	
	public static String toString(Object o) {
		return toString(o, "");
	}
	
	public static String toString(Object o, String def) {
		return o == null ? def : o.toString();
	}
	
	public static boolean toBoolean(Object o) {
		String s = toString(o);
		return "1".equals(s) || "true".equals(s);
	}
	
	public static String formatDate(Date date, String fmt) {
		return new SimpleDateFormat(fmt).format(date);
	}
	
	public static String numberPad(Object val, int len, String filling) {
		StringBuilder sb = new StringBuilder();
		sb.append(toString(val));
		while (sb.length() < len) {
			sb.insert(0, filling);
		}
		return sb.toString();
	}
}