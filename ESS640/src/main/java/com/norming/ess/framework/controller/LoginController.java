package com.norming.ess.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.norming.ess.base.LocalContext;
import com.norming.ess.common.Constants;
import com.norming.ess.framework.LoginException;
import com.norming.ess.framework.domain.UserInformation;
import com.norming.ess.framework.service.ILoginService;



@Controller
@RequestMapping(value="/framework/login")
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	@RequestMapping
	public String index() {
		return "framework/login/index";
	}

	@RequestMapping(value="/doLogin")
	public String doLogin(HttpServletRequest request, 
			@RequestParam("userid") String userid,
			@RequestParam("userpwd") String userpwd) {
		
		UserInformation userInfo = null;
		try {
			userInfo = loginService.doLogin(userid, userpwd);
		} catch (LoginException ex) {
			request.setAttribute("message", ex.getMessage());
			return index();
		}
		
		HttpSession session = request.getSession(true);
		LocalContext.setUser(userInfo);
		session.setAttribute(Constants.USER_BEAN, userInfo);
		
		return "redirect:/framework/homepage";
	}
}