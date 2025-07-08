package com.sakii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {
    "com.sakii.admin.repository",
    "com.sakii.user.repository",
    "com.sakii.friendship.repository",
    "com.sakii.matchmaking.repository",
    "com.sakii.progressive.repository",
    "com.sakii.report.repository"
})
public class SakiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakiiApplication.class, args);
	}

}
