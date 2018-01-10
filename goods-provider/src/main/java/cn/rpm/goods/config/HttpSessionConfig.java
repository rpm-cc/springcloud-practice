package cn.rpm.goods.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {
    //如果要使用redis存储spring session 首先要有对session的操作。
    // 没有任何session操作的话redis中不会存储任何东西。
}