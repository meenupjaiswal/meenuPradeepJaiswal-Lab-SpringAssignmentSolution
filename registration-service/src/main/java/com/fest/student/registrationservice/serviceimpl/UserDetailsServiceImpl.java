package com.fest.student.registrationservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fest.student.registrationservice.config.UserDetailsConfig;
import com.fest.student.registrationservice.entity.AppUser;
import com.fest.student.registrationservice.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = userRepository.findByUserName(username);
		if(appUser==null) {
			throw new UsernameNotFoundException("User not foud!");
		}
		return new UserDetailsConfig(appUser);
	}

}
