package com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.controller;

import com.mjmeal.mj_cafeteria_team_feedback_be.common.response.ApiResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto.UserRequest;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.dto.UserResponse;
import com.mjmeal.mj_cafeteria_team_feedback_be.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/ensure")
    public ApiResponse<UserResponse> ensure(@RequestBody UserRequest userRequest){
        return ApiResponse.onSuccess(userService.ensure(userRequest));
    }
}
