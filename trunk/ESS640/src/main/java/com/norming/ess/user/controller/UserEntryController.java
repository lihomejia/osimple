package com.norming.ess.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.norming.ess.user.domain.Ssuser;
import com.norming.ess.user.service.IUserService;

@Controller
@RequestMapping(value="/user/userEntry")
public class UserEntryController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value="/toAdd")
	public String toAdd() {
		return "user/userEntry/add";
	}

	@RequestMapping(value="/add")
	public String add(Ssuser user) {
		userService.addUser(user);
		return "redirect:/user/userList/findList";
	}

	@RequestMapping(value="/toEdit")
	public String toEdit(@RequestParam("id") String id, Model model) {
		Ssuser user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "user/userEntry/edit";
	}

	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request, Ssuser user) {
		userService.editUser(user);
		return "redirect:/user/userList/findList";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam("id") String id) {
		userService.deleteUser(id);
		return "redirect:/user/userList/findList";
	}
}
