package cn.com.norming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * 单元测试基类.
 * @author lh.jia
 * @date 2013.07.23
 */
@WebAppConfiguration
@ContextConfiguration(value={"classpath*:applicationContext*.xml","file:src/main/webapp/WEB-INF/springmvc-servlet.xml"})
public class AbstractContextControllerTests {
	@Autowired
	protected WebApplicationContext wac;
}