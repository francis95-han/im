/*
 * Copyright (c) 2020. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.im.client.config.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * file encoding: utf-8
 * Function : 客户端
 * Create : 3/8/2020 7:15 PM
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@Slf4j
@Component
public class NettyClient {

	@Value("${netty.server.host}")
	private String serverHost;

	@Value("${netty.server.port}")
	private Integer serverPort;

	public void start() {
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap()
				.group(group)
				//该参数的作用就是禁止使用Nagle算法，使用于小数据即时传输
				.option(ChannelOption.TCP_NODELAY, true)
				.channel(NioSocketChannel.class)
				.handler(new NettyClientInitializer());

		try {
			ChannelFuture future = bootstrap.connect(serverHost, serverPort).sync();
			log.info("客户端成功....");
			//发送消息
			future.channel().writeAndFlush("你好啊");
			// 等待连接被关闭
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}
	}
}
