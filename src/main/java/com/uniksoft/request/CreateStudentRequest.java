package com.uniksoft.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CreateStudentRequest {
	
	@JsonProperty("first_name")
	@NotBlank(message = "First name must not be blank") 
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String street;
	
	private String city;

}
