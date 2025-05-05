package com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.repostiory;

import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhoneNumber(String phoneNumber);
}
