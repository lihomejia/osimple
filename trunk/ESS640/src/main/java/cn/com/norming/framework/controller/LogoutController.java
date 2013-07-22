package cn.com.norming.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.norming.base.Constants;


@Controller
@RequestMapping(value="/framework/logout")
public class LogoutController {
	
	@RequestMapping
	public String index(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute(Constants.USER_BEAN);
			session.invalidate();
			
		} catch (Throwable t) {}
		
		return "redirect:/framework/login";
	}

}
