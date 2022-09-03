package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;

@RestController
public class BlogControllerTest {
	
	@GetMapping(path = "/test/hello")
	public String hello() {
		return "Hello World!!----11";
	}
}
