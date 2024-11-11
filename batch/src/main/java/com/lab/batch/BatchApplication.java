package com.lab.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.lab.core", "com.lab.batch"}) // core 및 admin 패키지 스캔
@EnableJpaRepositories(basePackages = "com.lab.core.repository") // core 모듈의 repository 패키지
@EntityScan(basePackages = "com.lab.core.domain") // core 모듈의 엔티티 패키지
public class BatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

}
