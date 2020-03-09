package xyz.zhangbohan.im.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.zhangbohan.im.server.config.netty.NettyServer;

import java.net.InetSocketAddress;


/**
 * @author bohan
 */
@SpringBootApplication
public class Application {

	private static NettyServer nettyServer;

	@Autowired
	public void setNettyServer(NettyServer nettyServer) {
		Application.nettyServer = nettyServer;
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
	}
}
