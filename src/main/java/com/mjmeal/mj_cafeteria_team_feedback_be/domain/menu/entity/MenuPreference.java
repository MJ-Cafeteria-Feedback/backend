package com.mjmeal.mj_cafeteria_team_feedback_be.domain.menu.entity;

import com.mjmeal.mj_cafeteria_team_feedback_be.common.entity.BaseEntity;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.meal.entity.Meal;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuPreference extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Meal meal;

    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;

    private int count;

    @Builder
    private void increment() {
        this.count += 1;
    }
}
