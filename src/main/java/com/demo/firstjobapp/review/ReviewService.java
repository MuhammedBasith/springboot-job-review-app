package com.demo.firstjobapp.review;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);
    void addReview(@PathVariable Long companyId, @RequestBody Review review);

    Review getAReview(Long companyId, Long reviewId);

    boolean updateReview(Long companyId, Long reviewId, Review review);

    boolean deleteReview(Long companyId, Long reviewId);
}
