package org.ankanchanda.jobapplication.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsByCompnayId(Long companyId);

    Review findReviewById(Long companyId, Long reviewId);

    boolean createReview(Long companyId, Review review);

    boolean deleteReview(Long companyId, Long reviewId);

    boolean updateReview(Long companyId, Long reviewId, Review review);
}
