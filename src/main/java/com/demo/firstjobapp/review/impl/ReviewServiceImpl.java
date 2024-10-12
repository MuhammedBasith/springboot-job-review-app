package com.demo.firstjobapp.review.impl;

import com.demo.firstjobapp.company.Company;
import com.demo.firstjobapp.company.CompanyService;
import com.demo.firstjobapp.review.Review;
import com.demo.firstjobapp.review.ReviewRepository;
import com.demo.firstjobapp.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CompanyService companyService;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public void addReview(Long companyId, Review review) {
        Company company = companyService.getACompany(companyId);

        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
        }
    }

    @Override
    public Review getAReview(Long companyId, Long reviewId) {
        Company company = companyService.getACompany(companyId);
        List<Review> reviews = company.getReviews();
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst().orElse(null);

    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review review){
        if (companyService.getACompany(companyId) != null){
            review.setCompany(companyService.getACompany(companyId));
            review.setId(reviewId);
            reviewRepository.save(review);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getACompany(companyId) != null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).get();
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(company, companyId);
            reviewRepository.deleteById(reviewId);
            return true;

        }
        return false;
    }

}
