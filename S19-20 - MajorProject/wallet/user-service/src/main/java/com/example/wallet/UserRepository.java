package com.example.wallet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByPhoneNumber(String phoneNumber);
}
