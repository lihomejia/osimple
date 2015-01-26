package com.norming.util;



/**
 * 
 * @author lh.jia
 * Created on 2015-01-26
 * 
 * @see org.apache.commons.lang3.ObjectUtils
 * @see java.util.Objects
 *
 */
public class ObjectUtil extends org.apache.commons.lang3.ObjectUtils {
	
	
	public static String toString(final Object obj) {
		return toString(obj, StringUtil.EMPTY);
	}

	public static String toString(final Object o, String nullDefault) {
        return java.util.Objects.toString(o, nullDefault);
    }
}
