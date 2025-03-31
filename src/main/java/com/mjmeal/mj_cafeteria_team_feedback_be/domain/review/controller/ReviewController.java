package com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.controller;

import com.mjmeal.mj_cafeteria_team_feedback_be.common.response.ApiResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.dto.request.RequestCreateReview;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.dto.response.ReviewResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    public final ReviewService reviewService;

    @PostMapping("/star")
    public ApiResponse<ReviewResponse> createReview(@RequestBody RequestCreateReview requestCreateReview) {
        ReviewResponse response = reviewService.createReview(requestCreateReview);
        return ApiResponse.onSuccess(response);
    }
}
