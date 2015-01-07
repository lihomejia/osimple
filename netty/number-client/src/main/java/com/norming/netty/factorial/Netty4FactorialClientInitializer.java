package com.norming.netty.factorial;


import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Netty4FactorialClientInitializer extends ChannelInitializer<SocketChannel>
 * Creates a newly Factorial for a client-side channel.
 * 
 * @author LiRui
 * @date May 27,2013
 */
public class Netty4FactorialClientInitializer extends ChannelInitializer<SocketChannel> {

    /** Prepare Channel Adapter*/
	private final ChannelInboundHandlerAdapter clientAdapter;
	
	/**
	 * Netty4 Factorial Client Initializer
	 * @param final ChannelInboundMessageHandlerAdapter<String> clientAdapter
	 * @param this
	 * @author LiRui
	 * @date May 27,2013
	 */
    public Netty4FactorialClientInitializer(final ChannelInboundHandlerAdapter clientAdapter) {
        this.clientAdapter = clientAdapter;
    }
    /**
     * Netty4 Channel & clientAdapter Builder
     * @param SocketChannel channel
     * @param this.ChannelInboundMessageHandlerAdapter<String> clientAdapter
     * @param LoggingHandler
     * @param ObjectEncoder
     * @param ObjectDecoder
     * 
     * @author LiRui
     * @date May 28,2013
     * */
    @Override
    public void initChannel(SocketChannel ch)throws Exception {
        ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO),
							  new ObjectEncoder(),
							  new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
		ch.pipeline().addLast("adapter", clientAdapter);
	}
}