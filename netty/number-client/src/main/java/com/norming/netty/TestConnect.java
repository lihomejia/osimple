package com.norming.netty;

import com.norming.netty.adapter.Netty4ClientAdapter;
import com.norming.netty.adapter.NumberClinetAdapter;
import com.norming.netty.domain.Feedback;
import com.norming.netty.util.OIOUtil;
/**
 * Netty4 Client connect to Server
 * 
 * IP & port ----Message---> server
 * Client   <----Message---- Server
 * 
 * @author LiRui
 * @date May 28,2013
 * **/
public class TestConnect {
	
	public static void main(String[] args) throws Exception {
		//Server hostIP
		String host = "192.168.1.110";
		//Server hostPort
		int    port = 11001;
		
		
		long t1 = System.currentTimeMillis();
		//loop connect to server
		for(int i = 0; i < 1; i++) {
			Netty4ClientAdapter adapter = new NumberClinetAdapter();
			adapter.setHost(host);
			adapter.setPort(port);
			Object ret = OIOUtil.doConnect(adapter);
			Feedback feedback = (Feedback) ret;
			System.out.println(feedback.getDocid());
		}
		long t2 = System.currentTimeMillis();
		
		System.out.println(t2 - t1);
		
		//clear cache
//		Netty4ClientAdapter<String> adapter = new NumberRefreshClinetAdapter();
//		adapter.setHost(host);
//		adapter.setPort(11000);
//		OIOUtil.doConnect2(adapter);
	}
}