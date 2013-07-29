package cn.com.norming.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.norming.base.util.DateUtil;
import cn.com.norming.base.web.util.WebUtil;
import cn.com.norming.demo.domain.JavaBean;

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
