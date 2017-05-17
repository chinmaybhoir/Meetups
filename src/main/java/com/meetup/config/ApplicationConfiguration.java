package com.meetup.config;



import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;


import com.meetup.service.UserService;

@Configuration
@EnableAutoConfiguration
public class ApplicationConfiguration {
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
	    return new HibernateJpaSessionFactoryBean();
	}
	@Bean
	public UserService userService(){
		return new UserService();
	}
	/*@Bean
	public EntityManagerFactory entityManagerFactory(){
		return new Entity
	}*/
}
