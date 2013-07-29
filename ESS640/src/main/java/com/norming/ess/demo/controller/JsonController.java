package com.norming.ess.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.norming.ess.base.util.DateUtil;
import com.norming.ess.base.web.util.WebUtil;
import com.norming.ess.demo.domain.JavaBean;


@Controller
@RequestMapping(value="/demo/json")
public class JsonController {

	@RequestMapping(value="/list")
	@ResponseBody
	public List<JavaBean> list(HttpServletRequest request) {
		System.out.println(WebUtil.getRequestMap(request));
		List<JavaBean> ret = new ArrayList<>();
		
		JavaBean bean = null;
		
		for (int i = 0; i < 20; i++) {
		
			bean = new JavaBean();
			ret.add(bean);
			
			bean.setName1("Name" + i);
			bean.setBirth(DateUtil.parse("2013-01-02"));
			bean.setLdt(new Timestamp(System.currentTimeMillis()));
		}
		
		
		return ret;
	}
}
