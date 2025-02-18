package com.qsl.qsl_tutorial;

import com.qsl.qsl_tutorial.boundedcontext.user.entity.SiteUser;
import com.qsl.qsl_tutorial.boundedcontext.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class QslTutorialApplicationTests {

	@Autowired
	private UserRepository repository;

	@Test
	@DisplayName("회원 생성")
	void createUserTest() {
		SiteUser user1 = new SiteUser(null, "user1", "{noop}1234", "user1@qsl.com");
		SiteUser user2 = new SiteUser(null, "user2", "{noop}1234", "user2@qsl.com");

		repository.saveAll(Arrays.asList(user1, user2));
	}

}
