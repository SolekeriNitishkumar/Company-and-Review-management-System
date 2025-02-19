package com.nitish.jobapp.impl.implclass;
import com.nitish.jobapp.Entity.Job;
import com.nitish.jobapp.DataLayerRepository.JobRepository;
import com.nitish.jobapp.impl.interfaces.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    //private List<Job> jobs  = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {

        jobRepository.save(job);

    }

    @Override
    public Job getJobById(long id) {

//        for (Job job : jobs)
//        {
//            if (Objects.equals(job.getJobid(), id))
//            {
//                return job;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(long id) {
//        for (Job job:jobs)
//        {
//            if(job.getJobid() == (id))
//            {
//                jobs.remove(job);
//                return true;
//
//            }
//        }
//        return false;
        try
        {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public boolean updateJobById(long id, Job reqjob) {
//        for (Job job : jobs)
//        {
//            if(job.getJobid() == id)
//            {
//                job.setJobid(reqjob.getJobid());
//                job.setTitle(reqjob.getTitle());
//                job.setDescription(reqjob.getDescription());
//                job.setLocation(reqjob.getLocation());
//                job.setMinsalary(reqjob.getMinsalary());
//                job.setMaxsalary(reqjob.getMaxsalary());
//                return true;
//            }
//        }
//        return false;
        Optional<Job> optionaljob = jobRepository.findById(id);
        if(optionaljob.isPresent())
        {
            Job job = optionaljob.get();
            //job.setJobid(reqjob.getJobid());
            job.setTitle(reqjob.getTitle());
            job.setDescription(reqjob.getDescription());
            job.setLocation(reqjob.getLocation());
            job.setMinsalary(reqjob.getMinsalary());
            job.setMaxsalary(reqjob.getMaxsalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
