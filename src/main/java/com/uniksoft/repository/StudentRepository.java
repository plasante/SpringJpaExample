package com.uniksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uniksoft.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
