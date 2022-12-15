package com.uniksoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniksoft.entity.Student;
import com.uniksoft.request.CreateStudentRequest;
import com.uniksoft.response.StudentResponse;
import com.uniksoft.service.StudentService;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
	
	@Autowired
	StudentService studenService;
	
	@Value("${app.name:Default Demo App}")
	private String appName;

	@GetMapping("get")
	public StudentResponse getStudent() {
		StudentResponse studentResponse = new StudentResponse(1, "Pierre", "Lasante");
		return studentResponse;
	}
	
	@GetMapping("getAllStudents")
	public List<StudentResponse> getAllStudents() {
		List<Student> studentList = studenService.getAllStudents();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		// It's not a good idea to expose an entity to the web
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@PostMapping("create")
	public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
		Student student = studenService.createStudent(createStudentRequest);
		
		return new StudentResponse(student);
	}
}
