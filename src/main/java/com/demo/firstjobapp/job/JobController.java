package com.demo.firstjobapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping()
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @PostMapping()
    public Job createJob(@RequestBody Job job){
        return jobService.createJob(job);
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteJobById(@PathVariable Long id){
        return jobService.deleteJobById(id);
    }

    @PutMapping("/{id}")
    public boolean updateJob(@PathVariable Long id, @RequestBody Job job){
        return jobService.updateJob(id, job);
    }
}
