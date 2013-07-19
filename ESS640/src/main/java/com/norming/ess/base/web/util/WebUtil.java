package com.norming.ess.base.web.util;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.norming.ess.base.util.BaseDto;
import com.norming.ess.base.util.Dto;

public class WebUtil {
	
	public static Dto getRequestMap(HttpServletRequest request) {
		Map<?, ?> map = request.getParameterMap();
		return cleanMap(map);
	}
	
	public static Dto cleanMap(Map<?, ?> map) {
		Dto dto = new BaseDto();
		if (map == null) {
			return dto;
		}

		for (Object key : map.keySet()) {
			Object val = map.get(key);
			if (val == null) {
				continue;
			}
			Class<?> c = val.getClass();
			if (c.isArray()) {
				Object[] vals = (Object[]) val;
				if (vals.length == 1) {
					val = vals[0];
				}
				else {
					val = Arrays.asList(vals);
				}
			}
			
			dto.put(key.toString(), val);
		}
		return dto;
	}
}