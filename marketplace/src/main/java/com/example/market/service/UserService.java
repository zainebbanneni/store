package com.example.market.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.model.User;
import com.example.market.repo.UserRepository;

@Service
@Transactional
public class UserService {
	private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void addUser(User user) {
		userRepository.save(user);
		
	}

}
