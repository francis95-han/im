/*
 * Copyright (c) 2020. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */
package xyz.zhangbohan.im.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.zhangbohan.im.client.config.netty.NettyClient;
/**
 * file encoding: utf-8
 * Function :
 * Create : 3/8/2020 7:11 PM
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@SpringBootApplication
public class Application {

	private static NettyClient nettyClient;

	@Autowired
	public void setNettyClient(NettyClient nettyClient) {
		Application.nettyClient = nettyClient;
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		nettyClient.start();
	}
}
