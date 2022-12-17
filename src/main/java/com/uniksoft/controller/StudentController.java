package com.uniksoft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniksoft.entity.Student;
import com.uniksoft.request.CreateStudentRequest;
import com.uniksoft.request.InQueryRequest;
import com.uniksoft.request.UpdateStudentRequest;
import com.uniksoft.response.StudentResponse;
import com.uniksoft.service.StudentService;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Value("${app.name:Default Demo App}")
	private String appName;

	@GetMapping("get")
	public StudentResponse getStudent() {
		StudentResponse studentResponse = new StudentResponse(1, "Pierre", "Lasante");
		return studentResponse;
	}
	
	@GetMapping("getAllStudents")
	public List<StudentResponse> getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		// It's not a good idea to expose an entity to the web
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@PostMapping("create")
	public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
		Student student = studentService.createStudent(createStudentRequest);
		
		return new StudentResponse(student);
	}
	
	@PutMapping("update")
	public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		
		Student student = studentService.updateStudent(updateStudentRequest);
		
		return new StudentResponse(student);
	}
	
	// http:8080/api/student/delete?id=4
//	@DeleteMapping("delete")
//	public String deleteStudent(@RequestParam("id") long id) {
//		return studentService.deleteStudent(id);
//	}
	
	// http:localhost:8080/api/student/delete/4
	@DeleteMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("getByFirstName/{firstName}")
	public List<StudentResponse> getByFirstName(@PathVariable String firstName) {
		List<Student> studentList = studentService.getByFirstName(firstName);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		// It's not a good idea to expose an entity to the web
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
		
	}
	
	@GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
	public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
		return new StudentResponse(studentService.getByFirstNameAndLastName(firstName, lastName));
	}
	
	@GetMapping("getByFirstNameIn")
	public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest) {
		List<Student> studentList = studentService.getByFirstNameIn(inQueryRequest);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@GetMapping("getAllStudentsWithSorting")
	public List<StudentResponse> getAllStudentsWithSorting() {
		List<Student> studentList = studentService.getAllStudentsWithSorting();
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@GetMapping("getAllWithPagination")
	public List<StudentResponse> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		List<Student> studentList = studentService.getAllStudentWithPagination(pageNo, pageSize);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@GetMapping("getByFirstNameOrLastName/{firstName}/{lastName}")
	public List<StudentResponse> getByFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName) {
		List<Student> students = studentService.getByFirstNameOrLastName(firstName, lastName);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		// It's not a good idea to expose an entity to the web
		students.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
}
