package cn.com.norming.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.norming.base.Constants;
import cn.com.norming.base.LocalContext;
import cn.com.norming.user.domain.User;
import cn.com.norming.user.service.IUserService;


@Controller
@RequestMapping(value="/framework/login")
public class LoginController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping
	public String index() {
		return "framework/login/index";
	}

	@RequestMapping(value="/doLogin")
	public String doLogin(HttpServletRequest request, 
			@RequestParam("userid") String userid,
			@RequestParam("userpwd") String userpwd) {

		
		User user = userService.findUserById(userid.toUpperCase());
		if (user == null || !userpwd.equals(user.getSsuserPwd())) {
			return index();
		}
		
		HttpSession session = request.getSession(true);
		
		LocalContext.setUser(user);
		
		session.setAttribute(Constants.USER_BEAN, user);
		
		return "redirect:/framework/homepage";
	}
}
