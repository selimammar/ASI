package com.sp.controller;


import com.sp.model.User;
import com.sp.requests.LoginRequest;
import com.sp.requests.RegisterRequest;
import com.sp.service.UserService;

import Common.cp.UserDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRestCrt {

	UserService userService;

	public UserRestCrt(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/auth/login")
	public UserDTO login(@RequestBody LoginRequest loginRequest) {
		return this.userService.login(loginRequest);
	}

	@PostMapping("/auth/register")
	public UserDTO register(@RequestBody RegisterRequest registerRequest){
		return this.userService.register(registerRequest);
	}
	
	@PostMapping("/user/{id}")
	public UserDTO update(@PathVariable int id, UserDTO user) {
		return this.userService.update(user);
	}

	
	@GetMapping("/user/{id}")
	public UserDTO getUser(@PathVariable int id){
		return this.userService.getUserById(id);
	}
	
}


