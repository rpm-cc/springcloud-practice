package cn.rpm.eureka.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaUserProvidertApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaUserProvidertApplication.class, args);
	}
}
