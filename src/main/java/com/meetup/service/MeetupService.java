package com.meetup.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.meetup.dao.MeetupDao;
import com.meetup.model.Meetup;
import com.meetup.model.MeetupAttendees;
import com.meetup.model.Response;

@Service
@ComponentScan("com.meetup")
public class MeetupService {
	@Autowired
	private MeetupDao meetupDao;
	public ArrayList<Meetup> getAllMeetups(){
		return meetupDao.getAllMeetups();
	}
	
	public Response addMeetup(Meetup newMeetup){
		return meetupDao.addMeetup(newMeetup);
	}
	
	public ArrayList<Meetup> getMeetup(String presenter){
		return meetupDao.getMeetup(presenter);
	}
	
	public ArrayList<MeetupAttendees> getAllAttendees(){
		return meetupDao.getAllAttendees();
	}
	
	public Response addAttendee(String meetup, String user){
		return meetupDao.addAttendee(meetup,user);
	}
}
