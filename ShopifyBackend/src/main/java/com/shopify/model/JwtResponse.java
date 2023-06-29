package com.shopify.model;

public class JwtResponse {

	private String token;

	public JwtResponse(String token) {
		setToken(token);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
