package com.meetup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.meetup.controllers.UserController;

@SpringBootApplication(scanBasePackages={"com.meetup"})

public class MeetupTest2Application {

	public static void main(String[] args) {
		SpringApplication.run(MeetupTest2Application.class, args);
	}
}
