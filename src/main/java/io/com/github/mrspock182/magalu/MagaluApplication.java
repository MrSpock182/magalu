package io.com.github.mrspock182.magalu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebSecurity
@EnableFeignClients
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MagaluApplication {
	public static void main(String[] args) {
		SpringApplication.run(MagaluApplication.class, args);
	}
}