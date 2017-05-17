package com.meetup.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meetup.model.Meetup;
import com.meetup.model.MeetupAttendees;
import com.meetup.model.Response;
import com.meetup.model.User;
@Transactional
@Repository
public class MeetupDaoImpl implements MeetupDao{
	@Autowired
	private SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Meetup> getAllMeetups() {
		Session session = sf.getCurrentSession();
		return (ArrayList<Meetup>) session.createCriteria(Meetup.class).list();
	}

	@Override
	public Response addMeetup(Meetup newMeetup) {
		Session session = sf.getCurrentSession();
		if(session.get(Meetup.class, newMeetup.getMeetTitle())==null){
			session.save(newMeetup);
			return new Response(200, "New meetup successfully added");
		} else {
			return new Response(400, "A meetup with given title is already registered.");
		}
	}

	@Override
	public ArrayList<Meetup> getMeetup(String presenter) {
		Session session = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		ArrayList<Meetup> meetList = (ArrayList<Meetup>) session.createCriteria(Meetup.class).add(Restrictions.eq("meetPresenter", presenter)).list();
		return meetList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<MeetupAttendees> getAllAttendees() {
		Session session = sf.getCurrentSession();
		return (ArrayList<MeetupAttendees>) session.createCriteria(MeetupAttendees.class).list();
	}

	@Override
	public Response addAttendee(String meetup, String userEmail) {
		Session session = sf.getCurrentSession();
		User tempUser = (User) session.get(User.class, userEmail);
		System.out.println("tempUser for "+userEmail+":"+tempUser);
		Meetup tempMeetup = (Meetup) session.get(Meetup.class, meetup);
		System.out.println("tempMeetup:"+tempMeetup);
		MeetupAttendees meetupAttendee = (MeetupAttendees) session.get(MeetupAttendees.class, meetup);
		if(meetupAttendee == null){
			System.out.println("meetupAttendee null");
			meetupAttendee = new MeetupAttendees(tempMeetup, new ArrayList<User>());
			System.out.println("meetupAttendees:"+meetupAttendee);
		}
		meetupAttendee.getAttendee().add(tempUser);
		System.out.println("meetupAttendee:"+meetupAttendee);
		session.save(meetupAttendee);
		return new Response(200, "New attendee successfully added");
	}

}
