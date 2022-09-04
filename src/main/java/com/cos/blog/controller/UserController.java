package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.model.User;

@Controller
public class UserController {

	@GetMapping("user/joinForm")
	public String joinForm(User user) {	
		return "user/joinForm";
	}
	
	@GetMapping("user/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
}
