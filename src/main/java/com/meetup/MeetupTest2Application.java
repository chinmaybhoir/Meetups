package com.meetup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.meetup"})

public class MeetupTest2Application {

	public static void main(String[] args) {
		SpringApplication.run(MeetupTest2Application.class, args);
	}
}
