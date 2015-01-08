package com.norming.netty.adapter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelHandler.Sharable;

import java.util.logging.Logger;

/**
 * Netty4.0 ServerAdapter  Netty4 I/O
 * Adapter back the received message to the client.
 * 
 */
@Sharable
public class Netty4ServerAdapter extends ChannelInboundHandlerAdapter {
	
    private static final Logger LOG = Logger.getLogger(Netty4ServerAdapter.class.getName());
    
    private String host;
	private int port;
	private boolean enable;
	
	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
	}


	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		
		LOG.info("Unexpected exception from downstream." + cause);
		
        ctx.close();
	}
	
    

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}