package com.nitish.jobapp.impl.interfaces;

import com.nitish.jobapp.Entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewByCompanyId(long id);
    Review getReviewByReviewID(long id);
    boolean updateReviewByReviewID(Review review,long id);
    boolean deleteReviewByReviewID(long id);
    boolean createReviewbyCompanyID(Review review, long id);

}
