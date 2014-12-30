package cn.com.norming.netty.adapter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Netty4ClientAdapter extends ChannelInboundHandlerAdapter {

	private static final Logger logger = Logger.getLogger(Netty4ClientAdapter.class.getName());
	
	private Object msg;
	private boolean isReceive = false;
	private boolean isCaught  = false;
	
	private String host;
	private int port;
	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		this.isReceive = true;
		this.msg = msg;
		ctx.close();
		
	}
	
	

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		if(isCaught){
			logger.log(Level.WARNING, "Unexpected exception from downstream.",cause);
			cause.printStackTrace();
		}
		ctx.close();
	}
	
	//////////////////////////////////////////////////////////////
	public Object getMsg() {
		return msg;
	}

	public boolean isReceive() {
		return isReceive;
	}

	public void setCaught(boolean isCaught) {
		this.isCaught = isCaught;
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
}