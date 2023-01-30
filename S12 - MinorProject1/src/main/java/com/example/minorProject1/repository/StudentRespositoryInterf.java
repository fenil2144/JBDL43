package com.example.minorProject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minorProject1.models.Student;

public interface StudentRespositoryInterf extends JpaRepository<Student, Integer>{

}
