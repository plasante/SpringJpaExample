package com.uniksoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uniksoft.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByFirstName(String firstName);
	
	Student findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameOrLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameIn(List<String> firstNames);
	
	List<Student> findByFirstNameContains(String firstName);

	List<Student> findByFirstNameStartsWith(String firstName);
	
	@Query("From Student where firstName = :firstName and lastName = :lastName")
	//@Query("From Student where firstName = ?1 and lastName = ?2")  Not Recommended
	Student getByFirstNameAndLastName(String firstName, String lastName);
	
	@Modifying
	@Transactional
	@Query("Update Student set firstName = :firstName where id = :id")
	Integer updateFirstName(Long id, String firstName);
	
	@Modifying
	@Transactional
	@Query("Delete From Student where firstName = :firstName")
	Integer deleteByFirstName(String firstName);
	
	//*** Go for Method proxy as much as possible
	// JPA Method proxy
	List<Student> findByAddressCity(String city);
	
	// JPQL
	@Query("From Student where address.city = :city")
	List<Student> getByAddressCity(String city);
	
}
