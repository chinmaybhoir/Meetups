package com.meetup.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class MeetupAttendees implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Meetup meetup;
	private ArrayList<User> attendees;
    public Meetup getMeetup() { return meetup; }
	public MeetupAttendees(){
		
	}
	public MeetupAttendees(Meetup meetup, ArrayList<User> attendees) {
		super();
		this.meetup = meetup;
		this.attendees = attendees;
	}
	
	public void setMeetup(Meetup meetup) {
		this.meetup = meetup;
	}
	public List<User> getAttendee() {
		return attendees;
	}
	public void setAttendee(ArrayList<User> attendees) {
		this.attendees = attendees;
	}
	@Override
	public String toString() {
		return "MeetupAttendees [meetup=" + meetup + ", attendees=" + attendees + "]";
	}
	
	
}
