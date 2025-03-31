package com.mjmeal.mj_cafeteria_team_feedback_be.common;

import lombok.Getter;

@Getter
public enum MealType {

    LUNCH("중식"),
    DINNER("석식");

    private final String displayName;

    MealType(String displayName) {
        this.displayName = displayName;
    }
}
