package com.shopify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopify.jwt.util.JwtUtil;
import com.shopify.model.JwtResponse;
import com.shopify.model.UserModel;
import com.shopify.serviceImpl.CustomUserDetailService;

@Controller
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailService userDetailService;

	@PostMapping(value="/generateToken")
	public ResponseEntity<?> generateToken(@RequestBody UserModel user){
		
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserId(), user.getPassword()));
			
		} catch(UsernameNotFoundException e) {
			e.printStackTrace();
			System.out.println("Bad credentials");
		} catch(BadCredentialsException e) {
			e.printStackTrace();
			System.out.println("Bad credentialss");
		}
		
		//if find
		UserModel userDetails = (UserModel) this.userDetailService.loadUserByUsername(user.getUserId());
		String token = this.jwtUtil.generateToken((UserDetails) userDetails);
		System.out.println("JWT Token is: " + token);
		
		//returning after converting to json
		//format is liken {tokenKey: value}
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
