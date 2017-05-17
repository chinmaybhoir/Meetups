package com.meetup.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.meetup.dao.UserDao;
import com.meetup.model.Response;
import com.meetup.model.User;
@Service
@ComponentScan("com.meetup")
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public void registerUser(User newUser){
		userDao.registerUser(newUser);
	}
	
	public Response loginUser(User user){
		return userDao.loginUser(user);
	}
	
	
}
