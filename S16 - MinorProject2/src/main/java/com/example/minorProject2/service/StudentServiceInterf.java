package com.example.minorProject2.service;

import com.example.minorProject2.models.Student;
import com.example.minorProject2.requests.StudentCreateRequest;

public interface StudentServiceInterf {
	Student save(StudentCreateRequest studentCreateRequest);
	Student saveFromStudent(Student student);
	Student findById(int studentId);
}
