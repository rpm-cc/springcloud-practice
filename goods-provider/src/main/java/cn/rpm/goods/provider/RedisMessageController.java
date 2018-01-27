package cn.rpm.goods.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by renpiming on 2018/1/13.
 */
@RestController
@RequestMapping(value = "/send")
public class RedisMessageController {


    @Autowired
    StringRedisTemplate template;

    @RequestMapping(value = "redis/msg")
    public String sendRedisMsg(@RequestParam String msg){

        template.convertAndSend("chat",msg);

        return null;
    }
}
