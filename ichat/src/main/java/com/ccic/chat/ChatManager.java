package com.ccic.chat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

/**
 * 处理聊天相关
 * 
 * 
 * 
 */
public class ChatManager {

	/** 保存当前在线用户列表 */
	public static List<User> users = new ArrayList<User>();

	/**
	 * 更新在线用户列表
	 * @param request
	 */
	public void updateUsersList(HttpServletRequest request) {
		User user = null;
		String flag="0";//标识用户，0:不存在  1:已存在
		String name= request.getSession().getAttribute("uname").toString();
		String pwd= request.getSession().getAttribute("pwd").toString();
		System.out.println("用户ID="+name+"   用户密码="+pwd);
		user = new User(pwd, name);
		//保存用户到列表
		//如果列表中无任何用户则添加，否则循环查找列表中是否已存在该用户，
		//如果不存在，则添加。如果存在，则不添加
		if(users.size() == 0){
			users.add(user);
		}else{
			for(int i=0;i<users.size();i++){
				User us =(User)users.get(i);
				if(us.getUsername().equals(name)){
					flag="1";
					break;	
				}
			}
			if(flag.equals("0")){
				users.add(user);
			}
		}
		
		/*//统计在线人数
		long count=OnlineCounter.getOnline();
		
		StringBuffer sb=new StringBuffer();
		sb.append("<script language='JavaScript' defer='defer'>");
		sb.append("d = new dTree(\'d\');");
		sb.append("d.add(0,-1,'在线用户列表(当前"+count+"人)');");
		for(int i=0;i<users.size();i++){
			User us =(User)users.get(i);
			sb.append("d.add("+(i+1)+",0,'"+us.getUsername()+"','','','');");
		}
		sb.append("document.write(d);");
		sb.append("d.config.useCookies=false;");
		sb.append("d.config.closeSameLevel=true;");
		sb.append("</script");//注意这里并不是好了“>”括号，而是在页面另有处理
		
		System.out.println("dd="+sb.toString());*/
		//将用户id和页面脚本session绑定
		//this.setScriptSessionFlag(user.getUsername());
		
		// 获得WEB上下文
        WebContext wctx = WebContextFactory.get();
		//获得在线列表 页面的所有脚本session
		Collection sessions = wctx.getScriptSessionsByPage("/ichat/pages/main/online_list.jsp");
		Util util = new Util(sessions);
		//处理这些页面中的一些元素
		//util.addFunctionCall("cBack_list", sb.toString());
		util.removeAllOptions("users");
		util.addOptions("users", users, "username");
	}

	/**
	 * 将用户id和页面脚本session绑定
	 * @param userid
	 */
	public void setScriptSessionFlag(String userid) {
		WebContextFactory.get().getScriptSession().setAttribute("userid", userid);
	}

	/**
	 * 根据用户id获得指定用户的页面脚本session
	 * @param userid
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ScriptSession getScriptSession(String userid, HttpServletRequest request) {
		ScriptSession scriptSessions = null;
		Collection<ScriptSession> sessions = new HashSet<ScriptSession>();
		sessions.addAll(ServerContextFactory.get(request.getSession().getServletContext())
				.getScriptSessionsByPage("/chat/index.jsp"));
		for (ScriptSession session : sessions) {
			String xuserid = (String) session.getAttribute("userid");
			if (xuserid != null && xuserid.equals(userid)) {
				scriptSessions = session;
			}
		}
		return scriptSessions;
	}
	
	/**
	 * 发送消息
	 * @param sender 发送人
	 * @param msg 发送内容
	 * @param request 发送请求
	 */
	public void send(String sender,String msg,HttpServletRequest request){
		System.out.println("sender="+sender+" msg="+msg);
        LinkedList<Message> messages = new LinkedList<Message>();
        if (msg != null && msg.trim().length() > 0) {
        	//AA 说(2010-07-13)： <br/>你好！
            messages.addFirst(new Message(sender,msg));
            while (messages.size() > 3) {
                messages.removeLast();
            }
        }
		
		// 获得WEB上下文
        WebContext wctx = WebContextFactory.get();
        //向指定页面推送消息
        Collection sessions = wctx.getScriptSessionsByPage("/ichat/pages/main/show_msg.jsp");
        Util utilAll = new Util(sessions);
        utilAll.addFunctionCall("callBack", messages);
	}
	
	//获得离线消息，思路：当A发消息给B时，将A用户发送的消息保存到B用户的ScriptSession中，
	//当B用户上线时把已经保持在B的ScriptSession中的消息读取处理并全部推送到页面。
	public void getOfflineMsg(){
		
	}
}
