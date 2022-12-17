package com.uniksoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uniksoft.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByFirstName(String firstName);
	
	Student findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameOrLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameIn(List<String> firstNames);
	
	List<Student> findByFirstNameContains(String firstName);
	
}
