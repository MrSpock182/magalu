package io.com.github.mrspock182.magalu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MagaluApplication {
	public static void main(String[] args) {
		SpringApplication.run(MagaluApplication.class, args);

//		String cep = "06449381";
//		System.out.println(test(cep));
	}

//	public static String test(String cep) {
//		StringBuilder replace = new StringBuilder(cep);
//
//		for (int i = cep.length(); i > 0; i--) {
//			System.out.println(cep);
//			replace.setCharAt(i - 1, '0');
//			cep = replace.toString();
//		}
//
//		return cep;
//	}
}