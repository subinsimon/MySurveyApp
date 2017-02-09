package com.mysurvey.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysurvey.entity.User;
import com.mysurvey.service.UserService;

@RestController
@RequestMapping("/mysurvey/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.POST,produces =MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody User user){
		userService.addUser(user);
	}

}
