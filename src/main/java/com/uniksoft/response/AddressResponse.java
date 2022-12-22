package com.uniksoft.response;

import com.uniksoft.entity.Address;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class AddressResponse {
	
	private long id;
	
	private String city;
	
	private String street;
	
	private String firstName;
	
	private String lastName;
	
	public AddressResponse(Address address) {
		this.id = address.getId();
		this.city = address.getCity();
		this.street = address.getStreet();
		
		this.firstName = address.getStudent().getFirstName();
		this.lastName = address.getStudent().getLastName();
	}

	public AddressResponse(long id, String street, String city) {
		this.id = id;
		this.street = street;
		this.city = city;
	}

}
