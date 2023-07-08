package com.shopify.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.user.model.UserCredentials;
import com.shopify.user.model.UserModel;
import com.shopify.user.service.AuthenticationService;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private AuthenticationService service;

	// Get User by Id
	@GetMapping(value = "/getUser")
	public UserModel getUser(@RequestBody UserCredentials user) {
		return this.service.getUser(user);
	}

	// Add User
	@PostMapping(value = "/saveUser")
	public String addUser(@RequestBody UserModel userModel) {
		return this.service.addNewUser(userModel);
	}
}
