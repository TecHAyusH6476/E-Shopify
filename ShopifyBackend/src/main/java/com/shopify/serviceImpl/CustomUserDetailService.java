package com.shopify.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shopify.model.UserModel;
import com.shopify.service.UserLoginService;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserLoginService loginService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(username.equals("Devansh")) {
			UserModel user = new UserModel();
			user.setUserId("devansh@gmail.com");
			user.setUserName("Devansh Agarwal");
			user.setPassword("abc@123");
			user.setUserType("user");
			return (UserDetails) user;
		}
		return null;
	}

}
