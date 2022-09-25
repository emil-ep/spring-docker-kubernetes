package com.innoventes.jukebox.batch;

import com.innoventes.jukebox.repository.MusicianRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private final MusicianRepository musicianRepository;

    public static final Logger LOGGER = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    @Autowired
    public JobCompletionNotificationListener(MusicianRepository musicianRepository){
        this.musicianRepository = musicianRepository;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JOB FINISHED! Time to verify the results");
//            repository.findAll().forEach(vehicle -> LOGGER.info(vehicle.getId()));
        }
    }
}

