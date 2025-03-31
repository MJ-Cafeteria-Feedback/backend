package com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.dto.request;

import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.MealType;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.entity.Review;
import lombok.Getter;

import java.math.BigDecimal;

public record RequestCreateReview(
        MealType mealType,
        BigDecimal rating
    ) {

    public Review toEntity() {
        return Review.builder()
                .mealType(mealType)
                .rating(rating)
                .user(null)
                .build();
    }
}
