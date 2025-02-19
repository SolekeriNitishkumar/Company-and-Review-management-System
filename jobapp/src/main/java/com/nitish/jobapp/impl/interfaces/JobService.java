package com.nitish.jobapp.impl.interfaces;

import com.nitish.jobapp.Entity.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job jobs);
    Job getJobById(long id);
    boolean deleteJobById(long id);
    boolean updateJobById(long id, Job reqjob);

}
