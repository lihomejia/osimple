package cn.chatroom.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.chatroom.entity.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 6427508929021173559L;

	private List<User> users = new ArrayList<User>(Arrays.asList(
		new User(1, "aa", "aa"),
		new User(2, "bb", "bb"),
		new User(3, "cc", "cc"),
		new User(4, "dd", "dd"),
		new User(5, "ee", "ee")
	));
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		for (User user : users) {
			
			if (user.getUsername().equals(username) 
					&& user.getPassword().equals(password)) {
				
				request.getSession().setAttribute("user", user);
				
				PrintWriter pw= response.getWriter();
				pw.write("<html><title></title><head><script type='text/javascript'> window.open('chat.jsp','chater','status=0,scrollbars=0,menubar=0,location=0,width=630,height=400');</script></head><body></body></html>");
				pw.flush();
				pw.close();
				return;
			}
		}
		request.setAttribute("loginErr","用户名或密码错误");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
