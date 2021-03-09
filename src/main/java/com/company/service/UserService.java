package com.company.service;

import java.util.List;

import com.company.dto.UserDTO;

public interface UserService {
	List<UserDTO> getUsers();
	UserDTO getUserById(Integer id);
}
