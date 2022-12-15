package com.uniksoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniksoft.entity.Student;
import com.uniksoft.repository.StudentRepository;
import com.uniksoft.request.CreateStudentRequest;
import com.uniksoft.request.UpdateStudentRequest;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student createStudent(CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);
		
		student = studentRepository.save(student);
		
		return student;
	}
	
	public String deleteStudent(long id) {
		studentRepository.deleteById(id);
		return "Student has been deleted successfully";
	}
	
	public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
		Student student = studentRepository.findById(updateStudentRequest.getId()).get();
		
		if (updateStudentRequest.getFirstName() != null && !updateStudentRequest.getFirstName().isEmpty()) {
			student.setFirstName(updateStudentRequest.getFirstName());
		}
		
		if (updateStudentRequest.getLastName() != null && !updateStudentRequest.getLastName().isEmpty()) {
			student.setLastName(updateStudentRequest.getLastName());
		}
		
		if (updateStudentRequest.getEmail() != null && !updateStudentRequest.getEmail().isEmpty()) {
			student.setEmail(updateStudentRequest.getEmail());
		}
		
		student = studentRepository.save(student);
		
		return student;
	}
}
