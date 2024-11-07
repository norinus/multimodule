package com.lab.batch.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class BasicTaskJobConfiguration {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public Job sampleJob() {
        return new JobBuilder("sampleJob", jobRepository)
                .start(sampleStep())
                .next(sampleStep2())
                .build();
    }

    @Bean
    public Step sampleStep() {
        return new StepBuilder("sampleStep", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    log.info("Sample Step executed");
                    return RepeatStatus.FINISHED;
                }, transactionManager)
                .build();
    }

    @Bean
    public Step sampleStep2() {
        return new StepBuilder("sampleStep2", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    log.info("Sample Step2 executed");
                    return RepeatStatus.FINISHED;
                }, transactionManager)
                .build();
    }
}