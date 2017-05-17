package com.meetup.dao;


import com.meetup.model.Response;
import com.meetup.model.User;

public interface UserDao {
	public void registerUser(User newUser);
	public Response loginUser(User user);
	
}
