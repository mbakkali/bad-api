package com.bad.applications;

import com.bad.applications.config.BCryptEncoderConfig;
import com.bad.applications.models.Role;
import com.bad.applications.models.User;
import com.bad.applications.repositories.UserRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	private PasswordEncoder passwordEncoder = new BCryptEncoderConfig().passwordEncoder();

	@Autowired
	UserRepository userRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	@Ignore
	public void insertRootUser() {
		User user = new User();
		user.setUsername("root");
		user.setPassword(passwordEncoder.encode("root"));
		user.grantAuthority(Role.ROLE_ADMIN);
		userRepository.save(user);
	}

}
