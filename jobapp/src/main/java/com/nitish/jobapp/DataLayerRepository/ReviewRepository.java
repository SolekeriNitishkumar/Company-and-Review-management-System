package com.nitish.jobapp.DataLayerRepository;

import com.nitish.jobapp.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long>
{

    List<Review> findByCompany_Cid(long cid);
}
