package com.mjmeal.mj_cafeteria_team_feedback_be.domain.menu.service;

import com.mjmeal.mj_cafeteria_team_feedback_be.domain.menu.dto.MenuRequest;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.menu.entity.Menu;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.menu.entity.MenuPreference;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.menu.entity.MenuPreferenceComment;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.menu.repository.MenuPreferenceCommentRepository;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.menu.repository.MenuPreferenceRepository;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final MenuPreferenceCommentRepository menuPreferenceCommentRepository;
    private final MenuPreferenceRepository menuPreferenceRepository;

    public void saveLikeMenu(MenuRequest menuRequest) {
        for (String name : menuRequest.getMenuNames()) {
            Menu menu = menuRepository.findByName(name);

            menuPreferenceRepository.save(
                    MenuPreference.builder()
                            .menu(menu)
                            .count(0)
                            .build()
            );

            if (menuRequest.getComment() != null && !menuRequest.getComment().isBlank()) {
                menuPreferenceCommentRepository.save(
                        MenuPreferenceComment.builder()
                                .menu(menu)
                                .comment(menuRequest.getComment())
                                .build()
                );
            }
        }
    }
}