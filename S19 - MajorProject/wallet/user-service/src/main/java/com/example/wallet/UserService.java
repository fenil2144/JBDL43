package com.example.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
		return userRepository.findByPhoneNumber(phoneNumber);
	}
	
	public void create(UserCreateRequest userCreateRequest) {
		User user = userCreateRequest.toUser();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setAuthorities(UserConstants.USER_AUTHORITY);
		user = userRepository.save(user);
		
	}
	
	

}
