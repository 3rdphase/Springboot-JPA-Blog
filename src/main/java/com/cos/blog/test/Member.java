package com.cos.blog.test;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@RequiredArgsConstructor
public class Member {
	private final int id;
	private final String username;	
	private final String password;
	private final String email;
}
