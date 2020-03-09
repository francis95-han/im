/*
 * Copyright (c) 2020. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.im.client.main.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
/**
 * file encoding: utf-8
 * Function : Netty客户端处理程序
 * Create : 3/8/2020 7:12 PM
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@Slf4j
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		log.info("客户端Active .....");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		log.info("客户端收到消息: {}", msg.toString());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}