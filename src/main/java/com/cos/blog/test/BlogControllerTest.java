package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {
	
	@GetMapping(value = "/test/lombok")
	public String lombokTest() {
		Member m = Member.builder()
								.id(1)
								.username("aaaa")
								.build();
		return "hi " + m.getUsername();		
	}
	
	@GetMapping(path = "/test/hello")
	public String hello(@RequestParam Member m) {
		return "Hello World!! " + ", " + m.getId();
	}
}
