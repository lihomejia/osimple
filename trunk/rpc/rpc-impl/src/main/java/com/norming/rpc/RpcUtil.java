package com.norming.rpc;

import com.norming.rpc.impl.RpcNettyMQFactory;
import com.norming.rpc.impl.RpcRmiFactory;

public class RpcUtil {

	
	private static IRpcContext context = null;
	
	static {
		init();
	}
	
	private static void init() {
		//TODO
		int flag = 1;
		if (flag == 1) {
			context = new RpcRmiFactory();
		} else if (flag == 2) {
			context = new RpcNettyMQFactory();
		}
	}
	
	
	public static <T> T getRpcInstance(Class<T> clazz) {
		return context.getRpcBean(clazz);
	}
	
	
}
