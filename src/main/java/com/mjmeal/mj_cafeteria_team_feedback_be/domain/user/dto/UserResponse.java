package com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto;

import java.math.BigDecimal;

public record UserResponse(
        String phoneNumber,
        BigDecimal point
) {
}
