package com.spring.security.entity.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.spring.security.entity.User;
import com.spring.security.event.RegistrationCompleteEvent;
import com.spring.security.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>{

	@Autowired
	private UserService userService;
	
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		// create the verification token for the user with the link
		
		User user = event.getUser();
		String token = UUID.randomUUID().toString();
		userService.saveVerificationTokenForUser(token, user);
		
		// send mail to user
		String url = event.getApplicationUrl()+ "verifyRegistration?token="+ token;
		
		// send email verification
		log.info("Click on the link to verify user", url);
		
	}

}
