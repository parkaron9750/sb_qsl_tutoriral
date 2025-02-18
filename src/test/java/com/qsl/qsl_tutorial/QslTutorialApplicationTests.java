package com.qsl.qsl_tutorial;

import com.qsl.qsl_tutorial.boundedcontext.user.entity.SiteUser;
import com.qsl.qsl_tutorial.boundedcontext.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QslTutorialApplicationTests {

	@Autowired
	private UserRepository repository;

	@Test
	@DisplayName("회원 생성")
	void createUserTest() {
		SiteUser user1 = SiteUser.builder()
				.username("user1")
				.password("{noop}1234")
				.email("user1@qsl.com")
				.build();

		SiteUser user2 = SiteUser.builder()
				.username("user2")
				.password("{noop}1234")
				.email("user2@qsl.com")
				.build();

//		SiteUser user1 = new SiteUser(null, "user1", "{noop}1234", "user1@qsl.com");
//		SiteUser user2 = new SiteUser(null, "user2", "{noop}1234", "user2@qsl.com");

		repository.saveAll(Arrays.asList(user1, user2));
	}

	@Test
	@DisplayName("1번 회원을 qsl로 가져오기")
	void getUserTest() {
		SiteUser user = repository.getQslUser(1L);

		assertThat(user.getId()).isEqualTo(1L);
		assertThat(user.getUsername()).isEqualTo("user1");
		assertThat(user.getPassword()).isEqualTo("{noop}1234");
		assertThat(user.getEmail()).isEqualTo("user1@qsl.com");
	}

}
