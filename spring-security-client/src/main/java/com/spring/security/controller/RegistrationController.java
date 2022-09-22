package com.spring.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.User;
import com.spring.security.event.RegistrationCompleteEvent;
import com.spring.security.model.UserModel;
import com.spring.security.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
		User user = userService.registerUser(userModel);
		publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
		return "Success";
	}

	private String applicationUrl(HttpServletRequest request) {
		return "https://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
	}

}
