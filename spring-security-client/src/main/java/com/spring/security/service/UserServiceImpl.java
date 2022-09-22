package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.entity.User;
import com.spring.security.entity.VerificationToken;
import com.spring.security.model.UserModel;
import com.spring.security.repository.UserRepository;
import com.spring.security.repository.VerificationTokenRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User registerUser(UserModel userModel) {
		User user = new User();
		user.setEmail(userModel.getEmail());
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		user.setRole("USER");
		
		userRepository.save(user);
		
		return user;
	}

	@Override
	public void saveVerificationTokenForUser(String token, User user) {
		VerificationToken verificationToken = new VerificationToken(user, token);
		verificationTokenRepository.save(verificationToken);
		
	}

}
