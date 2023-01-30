package com.example.minorProject1.service;

import com.example.minorProject1.models.Student;
import com.example.minorProject1.requests.StudentCreateRequest;

public interface StudentServiceInterf {
	Student save(StudentCreateRequest studentCreateRequest);
	Student saveFromStudent(Student student);
	Student findById(int studentId);
}
