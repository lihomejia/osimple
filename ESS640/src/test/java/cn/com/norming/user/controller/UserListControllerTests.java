package cn.com.norming.user.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import cn.com.norming.AbstractContextControllerTests;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserListControllerTests extends AbstractContextControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void findList() throws Exception {
		this.mockMvc.perform(get("/user/userList/findList"));
	}

}
