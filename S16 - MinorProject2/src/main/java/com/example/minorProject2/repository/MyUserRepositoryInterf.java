package com.example.minorProject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minorProject2.models.MyUser;

public interface MyUserRepositoryInterf extends JpaRepository<MyUser, Integer>{
	MyUser findByUsername(String username);
}
