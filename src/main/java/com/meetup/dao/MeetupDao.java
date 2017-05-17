package com.meetup.dao;

import java.util.ArrayList;

import com.meetup.model.Meetup;
import com.meetup.model.MeetupAttendees;
import com.meetup.model.Response;

public interface MeetupDao {
	public ArrayList<Meetup> getAllMeetups();
	public Response addMeetup(Meetup newMeetup);
	public ArrayList<Meetup> getMeetup(String presenter);
	public ArrayList<MeetupAttendees> getAllAttendees();
	public Response addAttendee(String meetup, String user);
}
