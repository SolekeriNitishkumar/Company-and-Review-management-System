package com.nitish.jobapp.Controller;

import com.nitish.jobapp.Entity.Job;
import com.nitish.jobapp.impl.interfaces.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs") // bas url for this controller
public class JobController {
    private JobService jobservice;

    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll()
    {
        return new ResponseEntity<>(jobservice.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job)
    {
        jobservice.createJob(job);
        return new ResponseEntity<>("Job successfully added",HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable long id)
    {
        Job job = jobservice.getJobById(id);
        if (job!=null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByJobId(@PathVariable long id)
    {
        boolean deletedID = jobservice.deleteJobById(id);
        if (deletedID) {
            return new ResponseEntity<>("Jobid " + id +  " has been successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Jobid "+ id + " not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}") //you can use this or below one
    //@RequestMapping(value="/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateByID(@PathVariable long id, @RequestBody Job reqjob)
    {
        boolean updatedId = jobservice.updateJobById(id,reqjob);
        if(updatedId)
        {
            return new ResponseEntity<>("Jobid " + id +  " has been successfully Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Jobid "+ id + " not found", HttpStatus.NOT_FOUND);
    }
}
