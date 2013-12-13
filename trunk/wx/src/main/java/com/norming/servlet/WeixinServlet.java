package com.norming.servlet;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.liufeng.course.message.resp.TextMessage;
import org.liufeng.course.util.MessageUtil;




public class WeixinServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String Token = "token";

	/**
	 * 用来接收微信公众平台的验证
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("----------get request ------------------");
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String[] ArrTmp = { Token, timestamp, nonce };
		Arrays.sort(ArrTmp);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ArrTmp.length; i++) {
			sb.append(ArrTmp[i]);
		}
		String pwd = Encrypt(sb.toString());
		String echostr = request.getParameter("echostr");
		System.out.println("pwd=="+pwd);
		System.out.println("echostr=="+echostr);
		if(pwd.equals(signature)){
			if(!"".equals(echostr) && echostr != null){
				response.getWriter().print(echostr);
			}
		}
	}

	/**
	 * 用来向普通用户传送信息
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		try {
			System.out.println(MessageUtil.parseXml(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TextMessage textMessage = new TextMessage();
		textMessage.setContent("Hi, now:" + new Date());
		
		response.getWriter().write(MessageUtil.textMessageToXml(textMessage));
		
	}


	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	public String Encrypt(String strSrc) {
		MessageDigest md = null;
		String strDes = null;

		byte[] bt = strSrc.getBytes();
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(bt);
			strDes = bytes2Hex(md.digest()); //to HexString
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Invalid algorithm.");
			return null;
		}
		return strDes;
	}

	public String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}
	
	public boolean isChinese(String str){  
	     boolean result=false;  
	     for (int i = 0; i < str.length(); i++){  
	          int chr1 = (char) str.charAt(i);  
	          if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)  
	              result = true;  
	          } 
	     }  
	     return result;  
	} 
}