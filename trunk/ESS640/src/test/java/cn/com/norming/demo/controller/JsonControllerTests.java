package cn.com.norming.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.ResultActions;

import cn.com.norming.AbstractContextControllerTests;

@RunWith(SpringJUnit4ClassRunner.class)
public class JsonControllerTests extends AbstractContextControllerTests {
	
	
	@Test
	public void list() throws Exception {
		
		ResultActions resultActions = this.mockMvc.perform(get("/demo/json/list"));
		MockHttpServletResponse response = resultActions.andReturn().getResponse();
		
		System.out.println(response.getContentAsString());
		
	}	
}
