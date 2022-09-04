package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final int id;
	
	@Column(nullable = false, length = 100)
	private final String title;
	
	@Lob
	private final String content;
	
	@ColumnDefault(value = "0")
	private final int count;
	
	//ORM은 User와 Board를 조인해서 쿼리를 날리는데 
	//User 오브젝트로 사용
	@ManyToOne(fetch = FetchType.EAGER) //Board가 Many이고  User가 One
	@JoinColumn(name = "userId") //FK 컬럼 생성
	private final User user;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //mappedBy는 연관관계에서 주인이 아니다(난 FK가 아니다 DB컬럼을 만들지 않음)
	private final List<Reply> reply;
	
	@CreationTimestamp
	private final Timestamp createDate;

}
