package com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.service;

import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.dto.request.RequestCreateReview;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.dto.response.ReviewResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.entity.Review;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public ReviewResponse createReview(RequestCreateReview requestCreateReview) {
        Review review = requestCreateReview.toEntity();
        reviewRepository.save(review);
        return new ReviewResponse(review.getId(), review.getMealType(), review.getRating());
    }
}
