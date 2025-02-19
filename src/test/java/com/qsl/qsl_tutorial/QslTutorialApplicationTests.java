package com.qsl.qsl_tutorial;

import com.qsl.qsl_tutorial.boundedcontext.user.entity.SiteUser;
import com.qsl.qsl_tutorial.boundedcontext.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@Transactional
@ActiveProfiles("test")
class  QslTutorialApplicationTests {

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


		repository.saveAll(Arrays.asList(user1, user2));
	}

	@Test
	@DisplayName("1번 회원을 qsl로 가져오기")
	void getUserTest() {
		SiteUser user = repository.getQslUser(1L);

		assertThat(user.getId()).isEqualTo(1L);
		assertThat(user.getUsername()).isEqualTo("user3");
		assertThat(user.getPassword()).isEqualTo("{noop}1234");
		assertThat(user.getEmail()).isEqualTo("user3@qsl.com");
	}

	@Test
	@DisplayName("모든 회원 수")
	void totalUserTest(){
		long count = repository.getQslCount();


		assertThat(count).isEqualTo(2L);
	}

	@Test
	@DisplayName("가장 오래된 회원")
	void oldUserTest(){
		SiteUser oldUser = repository.getQslOldUserAscOne();

		assertThat(oldUser.getId()).isEqualTo(1L);
		assertThat(oldUser.getUsername()).isEqualTo("user3");
		assertThat(oldUser.getPassword()).isEqualTo("{noop}1234");
		assertThat(oldUser.getEmail()).isEqualTo("user3@qsl.com");

	}

	@Test
	@DisplayName("전체 회원을 조회 오래된 순으로")
	void oldUserTest2(){
		repository.getQslOldUsersAsc();
	}

	@Test
	@DisplayName("회원 검색 기능")
	void searchUserTest(){
		List<SiteUser> userSearch = repository.searchQsl("user3");
		List<SiteUser> emailSearch = repository.searchQsl("user3@qsl.com");

		SiteUser user = userSearch.get(0);
		log.info("userSearch={}", userSearch);
		assertThat(user.getUsername()).isEqualTo("user3");

	}


}
