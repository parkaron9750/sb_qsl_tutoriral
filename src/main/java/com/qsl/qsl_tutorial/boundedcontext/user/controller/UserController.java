package com.qsl.qsl_tutorial.boundedcontext.user.controller;

import com.qsl.qsl_tutorial.boundedcontext.user.entity.SiteUser;
import com.qsl.qsl_tutorial.boundedcontext.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @GetMapping("/user/{id}")
    public SiteUser user(@PathVariable("id") Long id) {
       return repository.getQslUser(id);

    }

}
