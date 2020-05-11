package xyz.zhangbohan.im.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.zhangbohan.im.server.config.netty.NettyConfiguration;
import xyz.zhangbohan.im.server.config.netty.NettyServer;

import java.net.InetSocketAddress;


/**
 * @author bohan
 */
@SpringBootApplication
public class Application {
	private static NettyConfiguration nettyConfiguration;
	private static NettyServer nettyServer;

	@Autowired
	public void setNettyConofiguration(NettyConfiguration nettyConofiguration,NettyServer nettyServer) {
		Application.nettyConfiguration = nettyConofiguration;
		Application.nettyServer = nettyServer;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		nettyServer.start(new InetSocketAddress(nettyConfiguration.getServerHost(), nettyConfiguration.getServerPort()));
	}
}
