package com.mjmeal.mj_cafeteria_team_feedback_be.domain.meal.controller;

import com.mjmeal.mj_cafeteria_team_feedback_be.common.response.ApiResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.meal.dto.MealResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.meal.service.MealService;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.review.MealType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/meals")
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    @GetMapping("/today")
    public ApiResponse<MealResponse> getTodayMenu(@RequestParam("mealType") MealType mealType) {
        return ApiResponse.onSuccess(mealService.findMealByDateAndMealType(mealType));
    }
}
