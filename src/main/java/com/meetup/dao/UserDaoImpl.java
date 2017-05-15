package com.meetup.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meetup.model.Meetup;
import com.meetup.model.Response;
import com.meetup.model.User;
@Transactional
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sf;
	@Override
	public void registerUser(User newUser) {
		Session session = sf.getCurrentSession();
		session.save(newUser);
	}

	@Override
	public Response loginUser(User user) {
		Session session = sf.getCurrentSession();
		User tempUser = session.get(User.class, user.getUserEmail());
		if(tempUser==null)
			return new Response(400, "User does not exist");
		else if(tempUser.getUserPassword().equals(user.getUserPassword()))
			return new Response(200, "Login Successful");
		else 
			return new Response(400, "Incorrect password");
			
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Meetup> getAllMeetups(){
		Session session = sf.getCurrentSession();
		return (ArrayList<Meetup>) session.createCriteria(Meetup.class).list();
	}
	
	@Override
	public Response addMeetup(Meetup newMeetup){
		Session session = sf.getCurrentSession();
		session.save(newMeetup);
		return new Response(200, "New meetup successfully added");
	}
}
