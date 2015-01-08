package com.norming.netty.adapter;

import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.Map;

import com.norming.netty.domain.Feedback;
import com.norming.num.INumber;

public class NumberServerAdapter<T> extends Netty4ServerAdapter {
	
	private INumber number;

	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		Feedback feedback = new Feedback();
		try {
			feedback.setDocid(number.getAndIncrease(params));
		} catch (Exception ex) {
			feedback.setException(ex.getMessage());
		}
		ctx.writeAndFlush(feedback);
		super.channelRead(ctx, msg);
		
	}
	

	public void setNumber(INumber number) {
		this.number = number;
	}
}