package com.uniksoft.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uniksoft.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
public class StudentResponse {

	private long id;
	
	@JsonProperty("first_name")
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String street;
	
	private String city;
	
	private String fullName;

	public StudentResponse(Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.fullName = student.getFirstName() + " " + student.getLastName();
		
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
	}

	public StudentResponse(long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	

}
