package com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.service;

import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto.UserRequest;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto.UserResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.entity.User;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.repostiory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse ensure(UserRequest userRequest) {
        String phone = userRequest.getPhoneNumber();
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
}
