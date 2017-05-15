package com.meetup.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Meetup {
	@Id
	private String meetTitle;
	private String meetPresenter;
	private String meetDescription;
	private String meetGuest;
	private Date meetDate;
	private Time meetStartTime;
	private Time meetEndTime;
	public String getMeetTitle() {
		return meetTitle;
	}
	public void setMeetTitle(String meetTitle) {
		this.meetTitle = meetTitle;
	}
	public String getMeetPresenter() {
		return meetPresenter;
	}
	public void setMeetPresenter(String meetPresenter) {
		this.meetPresenter = meetPresenter;
	}
	public String getMeetDescription() {
		return meetDescription;
	}
	public void setMeetDescription(String meetDescription) {
		this.meetDescription = meetDescription;
	}
	public String getMeetGuest() {
		return meetGuest;
	}
	public void setMeetGuest(String meetGuest) {
		this.meetGuest = meetGuest;
	}
	public Date getMeetDate() {
		return meetDate;
	}
	public void setMeetDate(Date meetDate) {
		this.meetDate = meetDate;
	}
	public Time getMeetStartTime() {
		return meetStartTime;
	}
	public void setMeetStartTime(Time meetStartTime) {
		this.meetStartTime = meetStartTime;
	}
	public Time getMeetEndTime() {
		return meetEndTime;
	}
	public void setMeetEndTime(Time meetEndTime) {
		this.meetEndTime = meetEndTime;
	}
	
}
