package com.example.minorProject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minorProject1.models.Author;

public interface AuthorRepositoryInterf extends JpaRepository<Author, Integer>{

	Author findByEmail(String email);

}
