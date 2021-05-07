package com.dopang.machine.equitytrading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dopang.machine.equitytrading.domain.User;
import com.dopang.machine.equitytrading.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user){
		return userRepository.save(user);
	}
}
