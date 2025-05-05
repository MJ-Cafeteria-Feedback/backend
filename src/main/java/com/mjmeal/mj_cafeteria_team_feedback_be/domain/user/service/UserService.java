package com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.service;

import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto.UserEarnRequest;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto.UserEnsureRequest;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto.UserResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.entity.User;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.repostiory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse ensure(UserEnsureRequest userEnsureRequest) {
        String phone = userEnsureRequest.getPhoneNumber();
        User user = userRepository.findByPhoneNumber(phone);

        if (user == null) {
            user = User.builder()
                    .phoneNumber(phone)
                    .point(BigDecimal.ZERO)
                    .build();
            userRepository.save(user);
        }
        return new UserResponse(user.getPhoneNumber(), user.getPoint());
    }

    @Transactional
    public UserResponse earn(UserEarnRequest userEarnRequest) {
        User user = userRepository.findByPhoneNumber(userEarnRequest.getPhoneNumber());
        user.changePoint(userEarnRequest.getPoint());
        return new UserResponse(user.getPhoneNumber(), user.getPoint());
    }
}
