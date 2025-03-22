package org.ankanchanda.jobapplication.review.impl;

import java.util.List;

import org.ankanchanda.jobapplication.company.Company;
import org.ankanchanda.jobapplication.company.CompanyService;
import org.ankanchanda.jobapplication.review.Review;
import org.ankanchanda.jobapplication.review.ReviewRepository;
import org.ankanchanda.jobapplication.review.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviewsByCompnayId(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review findReviewById(Long companyId, Long reviewId) {
        return reviewRepository.findByCompanyId(companyId)
                .stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean createReview(Long compnayId, Review review) {
        Company company = companyService.findCompanyById(compnayId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(reviewRepository.findByCompanyId(companyId) != null
        && reviewRepository.existsById(reviewId)) {
            Review review = reviewRepository.findById(reviewId).get();
            Company company = review.getCompany();
            review.setCompany(null);
            company.getReviews().remove(review);
            boolean success =  companyService.updateCompany(companyId, company);
            return success;
        }
        return false;
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        Review review = reviewRepository.findByCompanyId(companyId)
        .stream()
        .filter(r -> r.getId().equals(reviewId))
        .findFirst()
        .orElse(null);

        if (review != null) {
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setTitle(updatedReview.getTitle());

            reviewRepository.save(review);
            return true;
        }
        return false;
    }

}
