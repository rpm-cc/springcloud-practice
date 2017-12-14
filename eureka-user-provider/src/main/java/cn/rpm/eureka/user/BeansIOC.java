package cn.rpm.eureka.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by renpiming on 2017/12/14.
 */
@Configuration
public class BeansIOC {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
