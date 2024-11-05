package com.lab.batch.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SampleJobScheduler {

    private final JobLauncher jobLauncher;
    private final Job sampleJob;

    @Autowired
    public SampleJobScheduler(JobLauncher jobLauncher, Job sampleJob) {
        this.jobLauncher = jobLauncher;
        this.sampleJob = sampleJob;
    }

    @Scheduled(fixedRate = 60000) // 60초마다 Job 실행
    public void runSampleJob() {
        try {
            JobParameters params = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(sampleJob, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}