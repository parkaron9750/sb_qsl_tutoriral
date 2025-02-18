package com.qsl.qsl_tutorial;

import com.qsl.qsl_tutorial.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class QslTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(QslTutorialApplication.class, args);
	}

}
