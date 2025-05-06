package com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.service;

import com.mjmeal.mj_cafeteria_team_feedback_be.common.exception.BusinessException;
import com.mjmeal.mj_cafeteria_team_feedback_be.common.response.error.ErrorCode;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto.UserEarnRequest;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto.UserEarnResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto.UserEnsureRequest;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto.UserEnsureResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.entity.User;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.repostiory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserEnsureResponse ensure(UserEnsureRequest userEnsureRequest) {
        String phone = userEnsureRequest.getPhoneNumber();
        User user = userRepository.findByPhoneNumber(phone);

        if (user == null) {
            user = User.builder()
                    .phoneNumber(phone)
                    .point(BigDecimal.ZERO)
                    .lastEarnDate(null)
                    .build();
            userRepository.save(user);
        }

        String todayStr = LocalDate.now(ZoneId.of("Asia/Seoul"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        boolean canEarnToday = user.getLastEarnDate() == null ||
                !user.getLastEarnDate().equals(todayStr);


        return new UserEnsureResponse(user.getPhoneNumber(), user.getPoint(), canEarnToday);
    }

    @Transactional
    public UserEarnResponse earn(UserEarnRequest userEarnRequest) {
        User user = userRepository.findByPhoneNumber(userEarnRequest.getPhoneNumber());

        String lastEarnDate = LocalDate.now(ZoneId.of("Asia/Seoul"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (user.getLastEarnDate() != null && user.getLastEarnDate().equals(lastEarnDate)) {
            throw new BusinessException(ErrorCode.ALREADY_EARNED_TODAY);
        }

        user.changePoint(userEarnRequest.getPoint());
        user.setLastEarnDate(lastEarnDate);
        return new UserEarnResponse(user.getPhoneNumber(), user.getPoint());
    }
}
