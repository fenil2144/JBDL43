package com.example.SecurityDemo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.SecurityDemo.Repository.MyUserRepository;
import com.example.SecurityDemo.model.MyUser;

@SpringBootApplication
public class SecurityDemoApplication implements CommandLineRunner{
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	MyUserRepository myUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		MyUser user1 = MyUser.builder().name("sai")
				.email("sai@gmail.com")
				.password(passwordEncoder.encode("sai123"))
				.authority("dev")
				.build();
		
		MyUser user2 = MyUser.builder().name("karan")
				.email("karan@gmail.com")
				.password(passwordEncoder.encode("karan123"))
				.authority("qa,admin")
				.build();
		
		myUserRepository.saveAll(Arrays.asList(user1,user2));
	}

}
