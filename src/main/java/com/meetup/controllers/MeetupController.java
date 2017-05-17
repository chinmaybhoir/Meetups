package com.meetup.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meetup.model.Meetup;
import com.meetup.model.MeetupAttendees;
import com.meetup.model.Response;
import com.meetup.service.MeetupService;

@RestController
@ComponentScan("com.meetup")
@RequestMapping("/meetup")
public class MeetupController {
	@Autowired
	private MeetupService meetupService;
	@RequestMapping(value = "/meetups", method = RequestMethod.GET)
	public ArrayList<Meetup> getAllMeetups(){
		System.out.println("inside getAllMeetup method");
		return meetupService.getAllMeetups();
	}
	
	@RequestMapping(value = "/addmeetup", method = RequestMethod.POST, headers = {"content-type=application/json"})
	public Response addMeetup(@RequestBody Meetup newMeetup){
		System.out.println("inside addMeetup method:"+newMeetup);
		return meetupService.addMeetup(newMeetup);
	}
	
	@RequestMapping(value = "/getmeetup/{presenter}", method = RequestMethod.GET)
	public ArrayList<Meetup> getMeetup(@PathVariable String presenter){
		System.out.println("inside getMeetup");
		return meetupService.getMeetup(presenter);
	}
	@RequestMapping(value = "/getattendees", method = RequestMethod.GET)
	public ArrayList<MeetupAttendees> getAllAttendees(){
		System.out.println("in getAllAttendees method");
		return meetupService.getAllAttendees();
	}
	
	@RequestMapping(value = "/addattendee", method = RequestMethod.GET)
	public Response addAttendee(@RequestParam(value="meetup", required=false) String meetup, @RequestParam(value="email", required=false) String user){
		System.out.println("in addAttendee method,meetup:"+meetup+" user:"+user);
		return meetupService.addAttendee(meetup,user);
	}
}
