/**
 * Copyright (C) Norming Information Technology Co.,Ltd. 2013. All 
 * rights reserved.
 *
 * This software is covered by the license agreement between the end user and
 * Norming Information Technology Co.,LTD., and may be used and copied 
 * only in accordance with the terms of the said agreement.
 * 
 * Norming Information Science Co.,LTD. assumes no responsibility or 
 * liability for any errors or inaccuracies in this software, 
 * or any consequential, incidental or indirect damage arising out of the use 
 * of the software.
 */
package com.norming.netty.util;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.oio.OioSocketChannel;

import java.net.InetSocketAddress;

import com.norming.netty.adapter.Netty4ClientAdapter;
import com.norming.netty.factorial.Netty4FactorialClientInitializer;

public class OIOUtil {
	
	/**
	 * 
	 * 适用于需要Server端返回的结果
	 * @param adapter
	 * @return
	 */
	public static Object doConnect(final Netty4ClientAdapter adapter) {
		Object ret = null;
		
		EventLoopGroup workerGroup = new OioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap();
		try {
			bootstrap
				.group(workerGroup).channel(OioSocketChannel.class)
				.remoteAddress(new InetSocketAddress(adapter.getHost(), adapter.getPort()))
				.handler(new Netty4FactorialClientInitializer(adapter))
				.option(ChannelOption.TCP_NODELAY, true)
			;
			
			ChannelFuture future = bootstrap.connect().sync();
			future.channel().closeFuture().sync();
			
			long s = System.currentTimeMillis();
			while (System.currentTimeMillis() - s <= 1000 * 30) {
				if(adapter.isReceive()){
					ret = adapter.getMsg();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
		}
		return ret;
	}
	
	/**
	 * 
	 * 适用于需要Server端返回的结果
	 * @param adapter
	 * @return
	 */
	public static void doConnect2(final Netty4ClientAdapter adapter){
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap();
		try {
			bootstrap
				.group(workerGroup).channel(NioSocketChannel.class)
				.remoteAddress(new InetSocketAddress(adapter.getHost(), adapter.getPort()))
				.handler(new Netty4FactorialClientInitializer(adapter))
			;
			ChannelFuture future = bootstrap.connect().sync();
			future.channel().closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
		}
	}
}