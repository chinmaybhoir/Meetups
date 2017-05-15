package com.meetup.dao;

import java.util.ArrayList;

import com.meetup.model.Meetup;
import com.meetup.model.Response;
import com.meetup.model.User;

public interface UserDao {
	public void registerUser(User newUser);
	public Response loginUser(User user);
	public ArrayList<Meetup> getAllMeetups();
	public Response addMeetup(Meetup newMeetup);
}
