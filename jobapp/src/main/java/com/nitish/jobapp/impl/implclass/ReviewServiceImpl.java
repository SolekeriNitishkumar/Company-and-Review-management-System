package com.nitish.jobapp.impl.implclass;

import com.nitish.jobapp.DataLayerRepository.CompanyRepository;
import com.nitish.jobapp.DataLayerRepository.ReviewRepository;
import com.nitish.jobapp.Entity.Company;
import com.nitish.jobapp.Entity.Review;
import com.nitish.jobapp.impl.interfaces.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;
    CompanyRepository companyRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyRepository companyRepository) {
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
    }

//    public ReviewServiceImpl(ReviewRepository reviewRepository) {
//        this.reviewRepository = reviewRepository;
//    }

    @Override
    public List<Review> getReviewByCompanyId(long id) {
        List<Review> reviews = reviewRepository.findByCompany_Cid(id);
        return reviews;
    }

    @Override
    public Review getReviewByReviewID(long id) {

        Optional<Review> optionalReview  = reviewRepository.findById(id);

        if (optionalReview.isPresent())
        {
            Review review = optionalReview.get();
            return review;
        }
        return null;



    }

    @Override
    public boolean createReviewbyCompanyID(Review review, long id) {
        Optional<Company> optionalCompany  = companyRepository.findById(id);

        if (optionalCompany.isPresent())
        {
            Company company = optionalCompany.get();
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

//    @Override
//    public Review getReviewByReviewID(long id) {
//        return null;
//    }
//
    @Override
    public boolean updateReviewByReviewID(Review review,long id) {

        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent())
        {
            Review review1 = optionalReview.get();
            review1.setDescription(review.getDescription());
            review1.setTitle(review.getTitle());
            review1.setRating(review.getRating());
            reviewRepository.save(review1);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteReviewByReviewID(long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent())
        {
            Review review1 = optionalReview.get();
            reviewRepository.delete(review1);
            return true;
        }

        return false;
    }
}
