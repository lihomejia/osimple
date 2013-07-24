package cn.com.norming.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.norming.base.util.DateUtil;
import cn.com.norming.demo.domain.JavaBean;

@Controller
@RequestMapping(value="/demo/json")
public class JsonController {

	@RequestMapping(value="/list")
	@ResponseBody
	public List<JavaBean> list() {
		List<JavaBean> ret = new ArrayList<>();
		
		JavaBean bean = new JavaBean();
		ret.add(bean);
		
		bean.setName("Name1");
		bean.setBirth(DateUtil.parse("2013-01-02"));
		bean.setLdt(new Timestamp(System.currentTimeMillis()));
		
		
		bean = new JavaBean();
		ret.add(bean);
		
		bean.setName("Name2");
		bean.setBirth(DateUtil.parse("2012-01-02"));
		bean.setLdt(new Timestamp(System.currentTimeMillis()));
		
		return ret;
	}
}
