package com.example.springdata;


import com.example.springdata.domain.model.User;
import com.example.springdata.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


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

		User user1 = new User("Kowalski", "xx");
		User user2 = new User("Nowak", "xx");
		User user3 = new User("Nowik", "xx");
		User user4 = new User("Kowalska", "xx");

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);

		System.out.println(userRepository.findByLogin("jkowalski"));
		System.out.println(userRepository.findByLoginAndName("jkowalski", "Kowalski"));

		Pageable pageable = PageRequest.of(0, 3, Sort.by(Sort.Direction.ASC, "name", "login"));
		System.out.println(userRepository.findByLogin("xx", pageable).getContent());
	}
}
