package org.liufeng.weixin.main;

import org.liufeng.weixin.pojo.AccessToken;
import org.liufeng.weixin.pojo.Button;
import org.liufeng.weixin.pojo.CommonButton;
import org.liufeng.weixin.pojo.ComplexButton;
import org.liufeng.weixin.pojo.Menu;
import org.liufeng.weixin.pojo.ViewButton;
import org.liufeng.weixin.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 菜单管理器类
 * 
 * @author liufeng
 * @date 2013-08-08
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wxf266a560fcd349d0";
		// 第三方用户唯一凭证密钥
		String appSecret = "54e6d1181aaa8d9cdc451a49cc05f41d";

		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());

			// 判断菜单创建结果
			if (0 == result)
				log.info("菜单创建成功！");
			else
				log.info("菜单创建失败，错误码：" + result);
		}
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		
		CommonButton btnText = new CommonButton();
		btnText.setName("测试Click");
		btnText.setType("click");
		btnText.setKey("testKey");
		
		ViewButton btnView = new ViewButton();
		btnView.setName("测试View1");
		btnView.setType("view");
		btnView.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf266a560fcd349d0&redirect_uri=http%3A%2F%2Fpsa03.cloudapp.net%2Fwx%2FsocialServlet&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
		
		ViewButton btnView2 = new ViewButton();
		btnView2.setName("测试View1");
		btnView2.setType("view");
		btnView2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf266a560fcd349d0&redirect_uri=http%3A%2F%2Fpsa03.cloudapp.net%2Fwx%2FsocialServlet&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
		
		
		CommonButton btn11 = new CommonButton();
		btn11.setName("News");
		btn11.setType("click");
		btn11.setKey("11");

		ViewButton btn12 = new ViewButton();
		btn12.setName("诺明动态");
		btn12.setType("view");
		btn12.setUrl("http://www.norming.com.cn/news.php?act=list");


		CommonButton btn21 = new CommonButton();
		btn21.setName("问答");
		btn21.setType("click");
		btn21.setKey("21");

		ViewButton btn22 = new ViewButton();
		btn22.setName("休假");
		btn22.setType("view");
		btn22.setUrl("http://psa.norming.com:8080/ess");

		CommonButton btn31 = new CommonButton();
		btn31.setName("找人");
		btn31.setType("click");
		btn31.setKey("31");

		CommonButton btn32 = new CommonButton();
		btn32.setName("社区");
		btn32.setType("click");
		btn32.setKey("32");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("资讯");
		mainBtn1.setSub_button(new Button[] { btn11, btn12});

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("办事");
		mainBtn2.setSub_button(new Button[] { btn21, btn22});

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("社区");
		mainBtn3.setSub_button(new Button[] { btn31, btn32});

		/**
		 * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br>
		 * 
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是"社区"，而直接是"社区"，那么menu应该这样定义：<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn32 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}
}