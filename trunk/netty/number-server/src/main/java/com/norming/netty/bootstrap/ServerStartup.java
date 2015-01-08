package com.norming.netty.bootstrap;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.norming.core.web.SpringContextHelper;
import com.norming.netty.adapter.Netty4ServerAdapter;
import com.norming.netty.factorial.Netty4FactorialServerInitializer;

public class ServerStartup {

	
	private static final Logger logger = Logger.getLogger(ServerStartup.class.getName());
	
	static {
		/** Initialize Spring Context*/
		if (!SpringContextHelper.isContextReady()) { 
			SpringContextHelper.setContext(new ClassPathXmlApplicationContext("applicationContext.xml"));
		}
	}
	

	public void startup() throws Exception {
		
		Map<String, Netty4ServerAdapter> handlers = 
				SpringContextHelper.getContext().getBeansOfType(Netty4ServerAdapter.class);
		
		
		for (Entry<String, Netty4ServerAdapter> ent : handlers.entrySet()) {
			
			final String handlerId = ent.getKey();
			final Netty4ServerAdapter adapter = ent.getValue();

			if (!adapter.isEnable()) {
				System.out.println(handlerId + " Server Disabled");
				continue;
			}
			new Thread() {
				
				@Override
				public void run() {
					String host = adapter.getHost();
					int port = adapter.getPort();
					
					EventLoopGroup bossGroup = new NioEventLoopGroup();
			        EventLoopGroup workerGroup = new NioEventLoopGroup();
					
					ServerBootstrap bootstrap = new ServerBootstrap();
			        try {
			        	bootstrap
			        		.group(bossGroup, workerGroup)
			        		.channel(NioServerSocketChannel.class)
			        		.localAddress(new InetSocketAddress(host, port))
			        		.childOption(ChannelOption.TCP_NODELAY, true)
			        		.childHandler(new Netty4FactorialServerInitializer(adapter));
			            ChannelFuture future;
						
						future = bootstrap.bind().sync();
						future.channel().closeFuture().sync();
			            logger.log(Level.INFO, "Netty4Server Bootstrap at:"+ port);
			        } catch (Exception e) {
			        	e.printStackTrace();
			        } finally {
			        	bossGroup.shutdownGracefully();
			        	workerGroup.shutdownGracefully();
			        }
				}
			}.start();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		new ServerStartup().startup();
	}
}