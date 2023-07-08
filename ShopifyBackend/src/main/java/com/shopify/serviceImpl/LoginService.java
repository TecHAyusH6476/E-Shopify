package com.shopify.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.convertor.Convertor;
import com.shopify.entity.User;
import com.shopify.model.UserModel;
import com.shopify.repository.UserRepository;
import com.shopify.service.UserLoginService;

@Service
public class LoginService implements UserLoginService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserModel userAuthentication(String userId) {
		User user = userRepository.findByUserId(userId);
		UserModel userDetails = Convertor.userEntityToModel(user);

		return userDetails;
	}

}
