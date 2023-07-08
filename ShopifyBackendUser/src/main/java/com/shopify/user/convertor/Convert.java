package com.shopify.user.convertor;

import com.shopify.user.entity.User;
import com.shopify.user.model.UserModel;

public class Convert {

	// user model to entity
	public static User UserModelToEntity(UserModel userModel) {
		User user = new User();
		user.setUserEmail(userModel.getUserEmail());
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setPassword(userModel.getPassword());
		user.setUserType(userModel.getUserType());
		return user;
	}

	// user entity to model
	public static UserModel UserEntityToModel(User user) {
		UserModel userModel = new UserModel();
		userModel.setUserEmail(user.getUserEmail());
		userModel.setFirstName(user.getFirstName());
		userModel.setLastName(user.getLastName());
		userModel.setPassword(user.getPassword());
		userModel.setUserType(user.getUserType());
		return userModel;
	}
}
