package cn.rpm.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserProvidertApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProvidertApplication.class, args);
	}
}
