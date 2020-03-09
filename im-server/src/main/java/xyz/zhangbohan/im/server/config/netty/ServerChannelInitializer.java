/*
 * Copyright (c) 2020. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.im.server.config.netty;

/**
 * file encoding: utf-8
 * Function : netty服务初始化器
 * Create : 3/8/2020 6:15 PM
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import xyz.zhangbohan.im.server.main.handler.NettyServerHandler;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		//添加编解码
		socketChannel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
		socketChannel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
		socketChannel.pipeline().addLast(new NettyServerHandler());
	}
}
