package cn.com.norming.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.norming.demo.domain.JavaBean;


@Controller
@RequestMapping(value="/demo/form")
public class FormController {

	@RequestMapping(value="/submit")
	public void submit(JavaBean bean) {
		System.out.println("bean:" + bean);
	}
}