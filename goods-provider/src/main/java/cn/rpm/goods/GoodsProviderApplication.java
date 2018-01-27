package cn.rpm.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("cn.rpm.goods.mapper")
@EnableEurekaClient
@SpringBootApplication
public class GoodsProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsProviderApplication.class, args);
	}

//	public static void main(String[] args) throws InterruptedException {
//
//		ApplicationContext ctx = SpringApplication.run(GoodsProviderApplication.class, args);
//
//		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
//		CountDownLatch latch = ctx.getBean(CountDownLatch.class);
//
//		template.convertAndSend("chat", "Hello from Redis!");
//
//		latch.await();
//
//		System.exit(0);
//	}

}
