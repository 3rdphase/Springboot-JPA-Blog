package com.cos.blog.model;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Builder
@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final int id;
	
	@Column(nullable = false, length = 200)
	private final String content;
	
	@ManyToOne //Reply가 Many이고  Board가 One
	@JoinColumn(name = "boardId")
	private final Board board;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private final User user;
	
	@CreationTimestamp
	private final Timestamp createDate;
}
