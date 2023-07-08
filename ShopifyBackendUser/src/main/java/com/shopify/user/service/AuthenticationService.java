package com.shopify.user.service;

import com.shopify.user.model.UserCredentials;
import com.shopify.user.model.UserModel;

public interface AuthenticationService {

	UserModel getUser(UserCredentials user);

	String addNewUser(UserModel userModel);

}
