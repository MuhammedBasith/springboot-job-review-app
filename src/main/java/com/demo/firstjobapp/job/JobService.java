package com.demo.firstjobapp.job;

import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {

    List<Job> findAll();
    Job createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);

}
