package com.norming.ess.test.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class TestController {
	
	@RequestMapping(value="/testJson")
	@ResponseBody
	public void testJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, List<Map<String, Object>>> map = new HashMap<>();

		List<Map<String, Object>> list = new ArrayList<>();
		map.put("items123", list);
		
		Map<String, Object> record = new HashMap<>();
		list.add(record);
		
		record.put("strA", "str1");
		record.put("intA", 1);
		
		record = new HashMap<>();
		list.add(record);
		
		record.put("strA", "str2");
		record.put("intA", 11);
		
		record = new HashMap<>();
		list.add(record);
		
		record.put("strA", "str3");
		record.put("intA", 13);
		
		
		
		boolean scriptTag = false;
		String cb = request.getParameter("callback");
		if (cb != null) {
			scriptTag = true;
			response.setContentType("text/javascript");
		} else {
			response.setContentType("application/x-json");
		}
		Gson gson = new Gson();
		
		
		Writer out = response.getWriter();
		if (scriptTag) {
			out.write(cb + "(");
		}
		out.write(gson.toJson(map));
		if (scriptTag) {
			out.write(");");
		}
		
		
	}
}