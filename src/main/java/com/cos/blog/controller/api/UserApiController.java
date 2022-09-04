package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		user.setRole(RoleType.USER);
		userService.join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //console.log({"status": OK, "data": 1})
	}

	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) throws Exception {
		User principal = userService.login(user);
System.out.println("+++++++");		
System.out.println(principal);		
System.out.println("+++++++");
		if (principal == null) {
			throw new Exception("비번틀림");
		}
		
		session.setAttribute("principal", principal);
	
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //console.log({"status": OK, "data": 1})
	}	
	
	@GetMapping("/api/user/logout")
	public ResponseDto<Integer> logout(HttpSession session) {
		session.invalidate();		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //console.log({"status": OK, "data": 1})
	}	
}
