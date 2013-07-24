package cn.com.norming.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import cn.com.norming.AbstractContextControllerTests;


@RunWith(SpringJUnit4ClassRunner.class)
public class FormControllerTests extends AbstractContextControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void submit() throws Exception {
		this.mockMvc.perform(get("/demo/form/submit?name=abc&birth=2012-01-23"));
	}	
}