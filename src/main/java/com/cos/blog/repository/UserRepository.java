package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;

//@Repository 를 하지 않아도 bean으로 등록
public interface UserRepository extends JpaRepository<User, Integer>{

}
