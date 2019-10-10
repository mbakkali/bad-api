package com.bad.applications;

import com.bad.applications.models.Role;
import com.bad.applications.models.User;
import com.bad.applications.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.stream.StreamSupport;

@SpringBootApplication()
public class Application {
	private final Environment env;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	public Application(Environment env, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.env = env;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.addListeners(new ApplicationPidFileWriter());
		springApplication.run(args);
	}

	@PostConstruct
	public void setupLocalDatabase(){
		if(Arrays.asList(env.getActiveProfiles()).contains("local")){
			logger.info("Creating root user ...");
			User user = new User();
			user.setUsername("root");
			user.setPassword(passwordEncoder.encode("root"));
			user.grantAuthority(Role.ROLE_ADMIN);
			userRepository.save(user);

			logger.info("Created root user with success");
			logger.info("Username : root");
			logger.info("Password : root");
		}else if(StreamSupport.stream(userRepository.findAll().spliterator(), false).count() == 0) {
			//First time
			User root = new User();
			root.setUsername("root");
			root.setPassword(passwordEncoder.encode("root"));
			root.grantAuthority(Role.ROLE_ADMIN);
			userRepository.save(root);

			logger.info("Created root user with success");
			logger.info("Username : root");
			logger.info("Password : root");
		}
	}


}
