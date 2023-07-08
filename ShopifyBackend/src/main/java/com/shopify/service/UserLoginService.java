package com.shopify.service;

import com.shopify.model.UserModel;

public interface UserLoginService {
	UserModel userAuthentication(String userId);
}
