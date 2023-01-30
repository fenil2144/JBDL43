package com.example.minorProject1.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minorProject1.models.Student;
import com.example.minorProject1.repository.StudentRespositoryInterf;
import com.example.minorProject1.requests.StudentCreateRequest;
import com.example.minorProject1.service.StudentServiceInterf;

@Service
public class StudentServiceImpl implements StudentServiceInterf{
	
	@Autowired
	StudentRespositoryInterf studentRespositoryInterf;

	@Override
	public Student save(StudentCreateRequest studentCreateRequest) {
		
		return saveFromStudent(studentCreateRequest.toStudent());
	}
	
	public Student saveFromStudent(Student student) {
		return studentRespositoryInterf.save(student);
	}

	@Override
	public Student findById(int studentId) {
		return studentRespositoryInterf.findById(studentId).get();
	}

}
