package com.company.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.UserDTO;
import com.company.service.UserService;

@RestController
@RequestMapping("/restapi")
public class UserAPI {
	
	@Autowired
	UserService userService;
	
	@GetMapping("v1/users")
	public ResponseEntity<List<UserDTO>> getUsers(){
		final List<UserDTO> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("v1/users/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
		final UserDTO user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
}
