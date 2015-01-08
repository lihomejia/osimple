package com.norming.netty.adapter;

import com.norming.num.util.NumberCustomUtil;
import com.norming.num.util.NumberSingleUtil;

import io.netty.channel.ChannelHandlerContext;

public class NumberRefreshServerAdapter extends Netty4ServerAdapter {
	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		NumberSingleUtil.refresh();
		NumberCustomUtil.refresh();
		ctx.write("");
		
		super.channelRead(ctx, msg);
		
	}
}