package com.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.entity.User;
import com.example.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService  {
	
	User save(UserRegistrationDto registrationDto);
	

}
