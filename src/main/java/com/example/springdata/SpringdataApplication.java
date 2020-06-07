package com.example.springdata;


import com.example.springdata.domain.model.User;
import com.example.springdata.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringdataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}

	private UserRepository userRepository;

	@Autowired
	public SpringdataApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Spring Boot Application started successfuly!");
		LOGGER.trace("Trace: Spring Boot Application started successfuly!");

		User user1 = new User("Kowalski", "jkowalski");
		User user2 = new User("Nowak", "anowak");

		userRepository.save(user1);
		userRepository.save(user2);

		System.out.println(userRepository.findByLogin("jkowalski"));
	}
}
