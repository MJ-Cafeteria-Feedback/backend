package com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.dto.response;

import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.MealType;

import java.math.BigDecimal;

public record ReviewResponse(
        Long id,
        MealType mealType,
        BigDecimal rating
    ) {
}
