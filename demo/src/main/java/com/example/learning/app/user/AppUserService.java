package com.example.learning.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService{
	private static final String USER_NOT_FOUND="User with the mail %s not found";

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email)
				.orElseThrow(
						() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
	}

}