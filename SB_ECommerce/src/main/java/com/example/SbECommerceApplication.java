package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SbECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbECommerceApplication.class, args);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "Acc1234$$";
		System.out.println("pass: "+passwordEncoder.encode(password));

	}
}