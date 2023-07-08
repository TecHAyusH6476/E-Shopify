package com.shopify.user.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.user.convertor.Convert;
import com.shopify.user.entity.User;
import com.shopify.user.model.UserCredentials;
import com.shopify.user.model.UserModel;
import com.shopify.user.repository.UserRepository;
import com.shopify.user.service.AuthenticationService;

@Service
public class AuthenticationServiceimpl implements AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	// Get user
	@Override
	public UserModel getUser(UserCredentials userCredentials) {
		User userDetails = this.userRepository.findByUserEmailAndPassword(userCredentials.getUserEmail(),
				userCredentials.getPassword());
		if(userDetails == null) {
			return null;
		}
		UserModel user = Convert.UserEntityToModel(userDetails);
		return user;
	}

	// Add new user
	@Override
	public String addNewUser(UserModel userModel) {
		Optional<User> isUserExist = this.userRepository.findById(userModel.getUserEmail());
		if (isUserExist.isPresent()) {
			return "User is already exist";
		}
		User user = Convert.UserModelToEntity(userModel);
		this.userRepository.save(user);
		return "User Add Successfully.";
	}

}
