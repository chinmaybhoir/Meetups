package com.meetup.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meetup.model.Meetup;
import com.meetup.model.Response;
import com.meetup.model.User;
import com.meetup.service.UserService;
@RestController
@ComponentScan("com.meetup")
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST, headers = {"content-type=application/json"})
	public void registerUser(@RequestBody User newUser){
		System.out.println("Inside registerUser method of usercontroller");
		userService.registerUser(newUser);
	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST, headers = {"content-type=application/json"})
	public Response loginUser(@RequestBody User user){
		System.out.println("inside loginUser method of userController");
		return userService.loginUser(user);
	}
	
	@RequestMapping(value = "/meetups", method = RequestMethod.GET)
	public ArrayList<Meetup> getAllMeetups(){
		System.out.println("inside getAllMeetup method");
		return userService.getAllMeetups();
	}
	
	@RequestMapping(value = "/addmeetup", method = RequestMethod.POST, headers = {"content-type=application/json"})
	public Response addMeetup(@RequestBody Meetup newMeetup){
		System.out.println("inside addMeetup method");
		return userService.addMeetup(newMeetup);
	}
}
