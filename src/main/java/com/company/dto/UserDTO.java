package com.company.dto;

import java.io.Serializable;

import com.company.entity.User;

public final class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private final String uName;

	public UserDTO(String uName) {
		this.uName = uName;
	}

	public String getuName() {
		return uName;
	}

	public static UserDTO of (User user) {
		return new UserDTO(user.getuName());
	}
}
