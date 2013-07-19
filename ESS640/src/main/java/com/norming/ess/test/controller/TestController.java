package com.norming.ess.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping(value="/query")
	@ResponseBody
	public Map<String, List<Map<String, Object>>> query() {
		
		Map<String, List<Map<String, Object>>> ret = new HashMap<>();
		
		List<Map<String, Object>> list1 = new ArrayList<>();
		
		Map<String, Object> record = new HashMap<>();
		record.put("menuID", "140298");
		record.put("title", "title1");
		record.put("text", "You1App");
		record.put("total", 2);
		
		list1.add(record);
		
		record = new HashMap<>();
		record.put("menuID", "140391");
		record.put("title", "title2");
		record.put("text", "You2App");
		record.put("total", 3);
		
		list1.add(record);
		
		ret.put("remindList", list1);
		
		
		list1 = new ArrayList<>();
		
		record = new HashMap<>();
		record.put("menuID", "140232");
		record.put("title", "title1");
		record.put("text", "You1App");
		record.put("total", 2);
		
		list1.add(record);
		
		record = new HashMap<>();
		record.put("menuID", "140288");
		record.put("title", "title2");
		record.put("text", "You2App");
		record.put("total", 3);
		
		list1.add(record);
		
		ret.put("applyList", list1);
		
		return ret;
	}
}
