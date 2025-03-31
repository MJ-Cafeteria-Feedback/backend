package com.mjmeal.mj_cafeteria_team_feedback_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MjCafeteriaTeamFeedbackBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MjCafeteriaTeamFeedbackBeApplication.class, args);
	}

}
