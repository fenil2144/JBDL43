package com.example.SecurityDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SecurityDemo.model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Integer>{
	MyUser findByEmail(String email);
}
