package com.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.entity.User;
import com.company.repository.UserRepository;
import com.company.service.MyUserDetails;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {
		
		User user = userRepo.getUserByUsername(uname);
		
		if (user == null) {
            throw new UsernameNotFoundException("User not find");
        }
         
        return new MyUserDetails(user);
		
	}

}
