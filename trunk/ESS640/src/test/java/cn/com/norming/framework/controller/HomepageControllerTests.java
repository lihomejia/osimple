package cn.com.norming.framework.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.norming.AbstractContextControllerTests;

@RunWith(SpringJUnit4ClassRunner.class)
public class HomepageControllerTests extends AbstractContextControllerTests {

	
	@Test
	public void index() throws Exception {
		this.mockMvc.perform(get("/framework/homepage"));
	}	

}
