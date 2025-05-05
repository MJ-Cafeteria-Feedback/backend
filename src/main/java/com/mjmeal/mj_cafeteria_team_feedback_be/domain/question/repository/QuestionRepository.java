package com.mjmeal.mj_cafeteria_team_feedback_be.domain.question.repository;

import com.mjmeal.mj_cafeteria_team_feedback_be.domain.menu.entity.Menu;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByMenuAndContent(Menu menu, String questionContent);
    List<Question> findByMenuIdIn(List<Long> menuIds);
}
