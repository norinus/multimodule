package com.lab.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lab.core", "com.lab.admin"}) // core 및 admin 패키지 스캔
@EnableJpaRepositories(basePackages = "com.lab.core.repository") // core 모듈의 repository 패키지
@EntityScan(basePackages = "com.lab.core.domain") // core 모듈의 엔티티 패키지
@EnableJpaAuditing
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
