package com.norming.ess.base.web.util;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;

import com.norming.ess.base.util.BaseDto;
import com.norming.ess.base.util.Dto;


/**
 * Web层面的工具类.
 * @author lh.jia
 * @date 2013.07.22
 */
public class WebUtil {
	
	/**
	 * 将request请求中的参数及值转成一个Map格式.
	 * @param request
	 * @return
	 */
	public static Dto getRequestMap(HttpServletRequest request) {
		Dto dto = new BaseDto();
		Enumeration<?> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = ObjectUtils.toString(enumeration.nextElement());
            String[] values = request.getParameterValues(name);
            
            Object val = null;
            if (values.length == 1) {
            	val = values[0];
            } else {
            	val = Arrays.asList(values);
            }
            dto.put(name, val);
        }
		return dto;
	}
}