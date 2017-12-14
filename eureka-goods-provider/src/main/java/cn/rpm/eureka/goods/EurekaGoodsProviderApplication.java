package cn.rpm.eureka.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
public class EurekaGoodsProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaGoodsProviderApplication.class, args);
	}
}
