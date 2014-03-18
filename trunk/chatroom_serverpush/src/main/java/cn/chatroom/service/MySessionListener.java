package cn.chatroom.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.directwebremoting.Container;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;

public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServerContext sc = ServerContextFactory.get();
		Container container = sc.getContainer();
		ScriptSessionManager ssm = 
				(ScriptSessionManager) container.getBean(ScriptSessionManager.class.getName());
		ssm.addScriptSessionListener(new ScriptSessionListener() {
			@Override
			public void sessionDestroyed(ScriptSessionEvent sse) {
				System.out.println("scriptSession销毁");
			}

			@Override
			public void sessionCreated(ScriptSessionEvent sse) {
				/*
				 * 缺陷：每个Session只能有一个用户登陆，如果多个用户登陆，由于每刷新一次，都会产生一个新的ScriptSession
				 * 同时每个Session有多个用户，那么将无法判断是哪个用户进行的刷新
				 */
				// 获取存储在ServletContext中的ScriptSessionMap
				ServerContext sc = ServerContextFactory.get();
				ServletContext servletContext = sc.getServletContext();

				// 取得Map
				@SuppressWarnings("unchecked")
				Map<String, ScriptSession> map = (Map<String, ScriptSession>) servletContext.getAttribute("ScriptSessionMap");
				
				if (map == null) {
					map = new HashMap<String, ScriptSession>();
					servletContext.setAttribute("ScriptSessionMap", map);
				}
				
				// 获取SessionId
				String httpSessionId = WebContextFactory.get().getSession().getId();
				Object user = WebContextFactory.get().getSession().getAttribute("user");
				sse.getSession().setAttribute("user", user);
				map.put(httpSessionId, sse.getSession());

				System.out.println(httpSessionId + " -- scriptSession创建");
			}
		});
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

	}

}
