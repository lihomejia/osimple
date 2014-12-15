package com.norming.rpc;

import com.norming.bo.ISyncSth;
import com.norming.rpc.impl.RpcRmiFactory;


public class RpcTest {

	public static void main(String[] args) {
		IRpcContext rpcHolder = new RpcRmiFactory();
		
		ISyncSth syncSth = rpcHolder.getRpcBean(ISyncSth.class);
		
		syncSth.syncSth2(1);
	}

}
