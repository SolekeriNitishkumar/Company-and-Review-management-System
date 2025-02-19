package com.nitish.jobapp.DataLayerRepository;

import com.nitish.jobapp.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
