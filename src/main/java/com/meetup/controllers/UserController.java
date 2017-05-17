package com.meetup.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meetup.model.Response;
import com.meetup.model.User;
import com.meetup.service.UserService;
@RestController
@ComponentScan("com.meetup")
@RequestMapping("/user")
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
	
	
}
