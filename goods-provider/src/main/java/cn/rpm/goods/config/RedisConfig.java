package cn.rpm.goods.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by renpiming on 2018/1/13.
 */
@Configuration
public class RedisConfig {
    //创建一个channel 名称为chat
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
        return container;
    }
    //将代理类delegate和代理中的方法传递给MessageListenerAdapter
    @Bean
    MessageListenerAdapter listenerAdapter(ReceiverDelegate receiverDelegate) {
        return new MessageListenerAdapter(receiverDelegate, "receiveMessage");
    }
    //创建代理类delegate
    @Bean
    ReceiverDelegate receiver() {
        return new ReceiverDelegate();
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
