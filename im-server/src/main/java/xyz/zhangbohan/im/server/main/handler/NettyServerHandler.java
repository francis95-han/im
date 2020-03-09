/*
 * Copyright (c) 2020. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.im.server.main.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
/**
 * file encoding: utf-8
 * Function : Netty服务端处理程序
 * Create : 3/8/2020 6:14 PM
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
	/**
	 * 客户端连接会触发
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		log.info("Channel active......");
	}

	/**
	 * 客户端发消息会触发
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		log.info("服务器收到消息: {}", msg.toString());
		ctx.write("你也好哦");
		ctx.flush();
	}

	/**
	 * 发生异常触发
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}