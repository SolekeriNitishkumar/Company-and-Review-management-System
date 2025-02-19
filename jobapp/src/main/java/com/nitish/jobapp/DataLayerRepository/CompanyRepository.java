package com.nitish.jobapp.DataLayerRepository;

import com.nitish.jobapp.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
