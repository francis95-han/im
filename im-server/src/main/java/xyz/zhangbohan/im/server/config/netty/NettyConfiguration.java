package xyz.zhangbohan.im.server.config.netty;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * file encoding: utf-8
 * Function :
 * Create : 2020/4/29 13:26
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@Data
@Component
public class NettyConfiguration {
	@Value("${netty.server.host}")
	private String serverHost;
	@Value("${netty.server.port}")
	private Integer serverPort;
}
