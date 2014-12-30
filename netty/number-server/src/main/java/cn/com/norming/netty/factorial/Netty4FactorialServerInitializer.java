package cn.com.norming.netty.factorial;


import io.netty.channel.ChannelInboundHandlerAdapter;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;


/**
 * Netty4FactorialServerInitializer extends ChannelInitializer<SocketChannel>
 * Creates a newly Factorial for a Netty4Server channel.
 */
public class Netty4FactorialServerInitializer extends
		ChannelInitializer<SocketChannel> {
	
	/** Prepare Channel Adapter **/
	private final ChannelInboundHandlerAdapter serverAdapter;
	
	public Netty4FactorialServerInitializer(
			final ChannelInboundHandlerAdapter serverAdapter) {
		this.serverAdapter = serverAdapter;
	}

	@Override
	public void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(
					new LoggingHandler(LogLevel.INFO),
					new ObjectEncoder(),
					new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
		channel.pipeline().addLast("adapter", serverAdapter);
	}
}
