package com.example.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.client.model.User;
import com.example.client.repositry.UserRepositoryBean;


@Service
public class CrmUserDetailsService implements UserDetailsService {
	
	@Autowired
	public UserRepositoryBean userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user2=userRepo.findByUsername(username);
	
		if(user2==null)
			throw new BadCredentialsException("Username or Password is invalid");
		
		new AccountStatusUserDetailsChecker().check(user2);
		
		return user2;
	}

}
