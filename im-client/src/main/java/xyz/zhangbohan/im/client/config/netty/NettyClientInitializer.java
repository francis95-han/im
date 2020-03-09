/*
 * Copyright (c) 2020. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.im.client.config.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import xyz.zhangbohan.im.client.main.handler.NettyClientHandler;
/**
 * file encoding: utf-8
 * Function : 客户端Netty初始化配置
 * Create : 3/8/2020 7:12 PM
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		socketChannel.pipeline().addLast("decoder", new StringDecoder());
		socketChannel.pipeline().addLast("encoder", new StringEncoder());
		socketChannel.pipeline().addLast(new NettyClientHandler());
	}
}