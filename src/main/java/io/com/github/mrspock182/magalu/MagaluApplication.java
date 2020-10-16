package io.com.github.mrspock182.magalu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MagaluApplication {
	public static void main(String[] args) {
		SpringApplication.run(MagaluApplication.class, args);
	}
}