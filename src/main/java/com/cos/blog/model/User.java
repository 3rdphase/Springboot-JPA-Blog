package com.cos.blog.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity //DB에 테이블이 생성된다 
@DynamicInsert //insert 시 null인 필드 제외
public class User {
	//GenerationType.IDENTITY 현 프로젝트에 연결된 db의 id전략을 따라간다. ex)mysql을 사용한다면 auto_increment, oracle을 사용한다면 sequence
	//GenerationType.SEQUENCE auto_increment 사용안됨
	//GenerationType.TABLE 테이블에 번호를 만들어두고 사용한다는 것
	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //id integer not null auto_increment,
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;

	@Column(nullable = false, length = 100) //비밀번호 해쉬로 암호화
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	 // enum으로 도메인을 만들어서 다른값이 들어오지 않게하는게 좋다. ex) 성별(도메인) : 남, 여
	//create문을 자동 생성해줄 때 적용
	//@ColumnDefault(value = "'user'")	//role varchar(255) default 'user',
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@CreationTimestamp
	private Timestamp createDate;
}
