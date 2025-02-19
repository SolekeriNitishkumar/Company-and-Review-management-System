package com.nitish.jobapp.Controller;

import com.nitish.jobapp.Entity.Review;
import com.nitish.jobapp.impl.interfaces.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies/{companyID}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviewByCompanyId(@PathVariable long companyID)
    {
        return new ResponseEntity<>(reviewService.getReviewByCompanyId(companyID), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReviewByCompanyId(@RequestBody Review review, @PathVariable long companyID)
    {
        boolean created = reviewService.createReviewbyCompanyID(review,companyID);
        if(created)
        {
            return new ResponseEntity<>("Review added succesfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("review couldn't be added succesfully",HttpStatus.NOT_FOUND);



    }
    @PutMapping("/reviews/{id}")
    public ResponseEntity<String> updateReviewByReviewID(@RequestBody Review review, @PathVariable long id)
    {
        boolean updated = reviewService.updateReviewByReviewID(review,id);
        if(updated)
        {
            return new ResponseEntity<>("Review updated succesfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("review couldn't be updated succesfully",HttpStatus.NOT_FOUND);

    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReviewByReviewID (@PathVariable long id)
    {
        Review review = reviewService.getReviewByReviewID(id);
        if(review!=null)
        {
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<String> deleteReviewByReviewID(@PathVariable long id)
    {
        boolean deleted = reviewService.deleteReviewByReviewID(id);
        if(deleted)
        {
            return new ResponseEntity<>("Review deleted succesfully",HttpStatus.OK);

        }
        return new ResponseEntity<>("review couldn't be deleted succesfully",HttpStatus.NOT_FOUND);
    }


}
