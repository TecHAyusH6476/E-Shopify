package com.shopify.convertor;

import com.shopify.entity.User;
import com.shopify.model.UserModel;

public class Convertor {

	// user Entity to Model
	public static UserModel userEntityToModel(User user) {
		UserModel userDetails = new UserModel();
		userDetails.setUserId(user.getUserId());
		userDetails.setPassword(user.getPassword());
		userDetails.setUserName(user.getUserName());
		userDetails.setUserType(user.getUserType());
		return userDetails;
	}
}
