package com.norming.netty.adapter;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class TestServerAdapter<T> extends Netty4ServerAdapter {
	

	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		ByteBuf buf = ctx.alloc().buffer(4);
		buf.writeInt(2);
		
		
		ctx.writeAndFlush(buf);
		super.channelRead(ctx, msg);
		
	}
	

}