package com.shopify.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.repository.UserRepository;
import com.shopify.service.UserLoginService;

@Service
public class LoginService implements UserLoginService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void userAuthentication() {
		
	}

}
