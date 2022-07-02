package com.example.demo.spring.batch.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Log4j2
@Component
@RequiredArgsConstructor
public class JobTask {

    private final JobLauncher jobLauncher;
    private final Job job;

    @Scheduled(fixedRate = 5000)
    public void executeJob() throws Exception {
        log.info("Inicio de JobTask.executeJob: {}", new Date());
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();

        jobLauncher.run(job, jobParameters);
    }

}
