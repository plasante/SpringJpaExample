package com.uniksoft.entity;

import javax.persistence.*;

import com.uniksoft.request.CreateStudentRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	
	//Owning side of the relationship
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	// need to provide mappedBy attribute on the non-owning side
	@OneToMany(mappedBy = "student")
	private List<Subject> learningSubjects;
	
	@Transient
	private String fullName;
	
	public Student(CreateStudentRequest createStudentRequest) {
		this.firstName = createStudentRequest.getFirstName();
		this.lastName = createStudentRequest.getLastName();
		this.email = createStudentRequest.getEmail();
		this.fullName = createStudentRequest.getFirstName() + " " + createStudentRequest.getLastName();
	}
}
