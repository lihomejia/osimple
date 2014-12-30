package cn.com.norming.netty.adapter;

import io.netty.channel.ChannelHandlerContext;
import cn.com.norming.num.util.NumberCustomUtil;
import cn.com.norming.num.util.NumberSingleUtil;

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