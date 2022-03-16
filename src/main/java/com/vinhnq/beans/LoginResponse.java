package com.vinhnq.beans;

import lombok.Data;

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 5/1/2019
 * Github: https://github.com/loda-kun
 */
@Data
public class LoginResponse {
	private String username;
    private String accessToken;
    private String tokenType = "Bearer";

    public LoginResponse(String userName, String accessToken) {
    	this.setUsername(userName);
        this.setAccessToken(accessToken);
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@Override
	public String toString() {
		return "LoginResponse [accessToken=" + accessToken + ", tokenType=" + tokenType + "]";
	}
	
	
    
}