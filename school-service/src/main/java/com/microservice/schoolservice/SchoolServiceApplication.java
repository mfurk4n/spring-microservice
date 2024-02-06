package com.microservice.schoolservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//yeni sürümlerde @EnableEurekaClient veya @EnableDiscoveryClient olmadan spring tanımlama yapabilir.
@SpringBootApplication
public class SchoolServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolServiceApplication.class, args);
	}

}
