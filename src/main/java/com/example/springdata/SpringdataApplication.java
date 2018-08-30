package com.example.springdata;

import com.example.springdata.domain.model.User;
import com.example.springdata.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.springdata.repository")
public class SpringdataApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringdataApplication.class);

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}

	@Override
	public void run(String... args) {
		final String username = "kowalskij";
		LOGGER.info("Getting user for username={}", username);
		final User foundUser = userService.findByUsername(username);
		LOGGER.info("Found user: {}", foundUser);
		final User userForAdding = new User("nowaka", "Andrzej", "Nowak");
		LOGGER.info("User added: {}", userService.save(userForAdding));
	}
}
