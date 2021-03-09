package com.company.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> getUsers() {
		return userRepo.findAll().stream().map(UserDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO getUserById(Integer id) {
		final User user = userRepo.findById(id).get();
		return UserDTO.of(user);
	}

}
