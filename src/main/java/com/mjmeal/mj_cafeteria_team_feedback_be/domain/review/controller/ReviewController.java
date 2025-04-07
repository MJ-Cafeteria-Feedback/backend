package com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.controller;

import com.mjmeal.mj_cafeteria_team_feedback_be.common.response.ApiResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.dto.ReviewRequest;
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

    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<Void> save(@RequestBody ReviewRequest request) {
        reviewService.save(request);
        return ApiResponse.onSuccess(null);
    }
}
