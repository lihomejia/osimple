package com.norming.ess.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.norming.ess.demo.domain.JavaBean;



@Controller
@RequestMapping(value="/demo/form")
public class FormController {

	@RequestMapping(value="/submit")
	public void submit(JavaBean bean) {
		System.out.println("bean:" + bean);
	}
}