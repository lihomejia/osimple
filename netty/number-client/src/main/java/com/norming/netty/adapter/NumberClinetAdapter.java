package com.norming.netty.adapter;

import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.Map;

public class NumberClinetAdapter extends Netty4ClientAdapter {

	private Map<String, Object> params = new HashMap<String, Object>();

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		ctx.writeAndFlush(params);
	}
	
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}