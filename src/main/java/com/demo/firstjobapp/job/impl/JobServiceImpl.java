package com.demo.firstjobapp.job.impl;

import com.demo.firstjobapp.job.Job;
import com.demo.firstjobapp.job.JobRepository;
import com.demo.firstjobapp.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {

//    private List<Job> jobs = new ArrayList<>();
    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob(Job job) {
        jobRepository.save(job);
        return job;
    }

    @Override
    public Job getJobById(Long id){
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id){
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob){
        Optional<Job> jobOptional = jobRepository.findById(id);

        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());

            jobRepository.save(job);
            return true;
        }

        return false;

    }
}
