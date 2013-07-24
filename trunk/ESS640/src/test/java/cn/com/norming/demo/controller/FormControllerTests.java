package cn.com.norming.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.norming.AbstractContextControllerTests;


@RunWith(SpringJUnit4ClassRunner.class)
public class FormControllerTests extends AbstractContextControllerTests {

	@Test
	public void submit() throws Exception {
		this.mockMvc.perform(post("/demo/form/submit?name=abc&birth=2012-01-23&ldt=2013-07-24 12:36:40"));
	}	
}