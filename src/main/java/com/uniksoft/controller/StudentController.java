package com.uniksoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniksoft.entity.Student;
import com.uniksoft.response.StudentResponse;
import com.uniksoft.service.StudentService;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
	
	@Autowired
	StudentService studenService;
	
	@Value("${app.name:Default Demo App}")
	private String appName;

	@GetMapping("/get")
	public StudentResponse getStudent() {
		StudentResponse studentResponse = new StudentResponse(1, "Pierre", "Lasante");
		return studentResponse;
	}
	
	@GetMapping("getAllStudents")
	public List<StudentResponse> getAllStudents() {
		List<Student> studentList = studenService.getAllStudents();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
}
