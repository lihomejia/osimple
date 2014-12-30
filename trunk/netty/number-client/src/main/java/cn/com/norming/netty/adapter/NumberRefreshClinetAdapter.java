package cn.com.norming.netty.adapter;

import io.netty.channel.ChannelHandlerContext;

public class NumberRefreshClinetAdapter extends Netty4ClientAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.write("");
	}
}