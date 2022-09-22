package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.User;

@Service
public class UserService {
	
	List<User> users = new ArrayList<>();

	public UserService() {
		users.add(new User("abc", "abc", "abc@gmail.com"));
		users.add(new User("xyz", "xyz", "xyz@gmail.com"));
	}
	
	public List<User> getAllUsers(){
		return this.users;
	}
	
	public User getUser(String username) {
		return this.users.stream().filter((user)->user.getPassword().equals(username)).findAny().get();
	}
	
	public User addUser(User user) {
		this.users.add(user);
		return user;
	}

}
