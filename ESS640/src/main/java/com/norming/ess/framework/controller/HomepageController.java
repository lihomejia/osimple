package com.norming.ess.framework.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.norming.ess.framework.service.IUserMenu;


@Controller
@RequestMapping(value="/framework/homepage")
public class HomepageController {

	@Autowired
	private IUserMenu userMenu;
	
	@RequestMapping
	public String index() {
		return "framework/homepage/index";
	}
	
	
	@RequestMapping(value="/queryShortcuts")
	@ResponseBody
	public List<Map<String, Object>> queryShortcuts() {
		return userMenu.queryShortcuts();
	}
}
