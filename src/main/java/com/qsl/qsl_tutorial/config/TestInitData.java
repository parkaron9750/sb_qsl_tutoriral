package com.qsl.qsl_tutorial.config;

import com.qsl.qsl_tutorial.boundedcontext.user.entity.SiteUser;
import com.qsl.qsl_tutorial.boundedcontext.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile({"test"}) //개발 환경과 테스트 환경에서마 실행
public class TestInitData {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository) {
        return args ->{
            //Spring boot 앱이 실행되고, 본격적으로 작동하기 전에 실행된다.
            SiteUser user3 = SiteUser.builder()
                    .username("user3")
                    .password("{noop}1234")
                    .email("user3@qsl.com")
                    .build();

            SiteUser user4 = SiteUser.builder()
                    .username("user4")
                    .password("{noop}1234")
                    .email("user4@qsl.com")
                    .build();

            List<SiteUser> users = userRepository.saveAll(Arrays.asList(user3, user4));
        };
    }

}
