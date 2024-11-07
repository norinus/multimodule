package com.lab.batch.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BatchJobScheduler {

    private final JobLauncher jobLauncher;
    private final Job sampleJob;

    @Scheduled(fixedRate = 60000) // 60초마다 Job 실행
    public void runSampleJob() {
        try {
            JobParameters params = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(sampleJob, params);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}