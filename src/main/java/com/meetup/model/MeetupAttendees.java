package com.meetup.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MeetupAttendees {
	@OneToMany
	private Meetup meetup;
	@OneToMany
	private User attendee;
	public Meetup getMeetup() {
		return meetup;
	}
	public void setMeetup(Meetup meetup) {
		this.meetup = meetup;
	}
	public User getAttendee() {
		return attendee;
	}
	public void setAttendee(User attendee) {
		this.attendee = attendee;
	}
	
	
}
