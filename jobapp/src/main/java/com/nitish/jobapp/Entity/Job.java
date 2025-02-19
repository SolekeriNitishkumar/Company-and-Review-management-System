package com.nitish.jobapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jobid;
    private String title;
    private String description;
    private String minsalary;
    private String maxsalary;
    private String location;

    @ManyToOne
    //@JsonIgnore
    private Company company;

 ;   public Job() {
    }

    public Job(long jobid, String title, String description, String minsalary, String maxsalary, String location) {
        this.jobid = jobid;
        this.title = title;
        this.description = description;
        this.minsalary = minsalary;
        this.maxsalary = maxsalary;
        this.location = location;
    }

    public long getJobid() {
        return jobid;
    }

    public void setJobid(long jobid) {
        this.jobid = jobid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(String minsalary) {
        this.minsalary = minsalary;
    }

    public String getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(String maxsalary) {
        this.maxsalary = maxsalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobid=" + jobid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", minsalary='" + minsalary + '\'' +
                ", maxsalary='" + maxsalary + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
