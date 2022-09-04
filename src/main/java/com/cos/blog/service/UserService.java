package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {
	//트랜젝션관리
	//서비스의의미 : 
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void join(User user) {
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true) //select 시 트랜젝션시작 서비스종료시 트랜젝션종료(정합성)
	public User login(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}	
}
