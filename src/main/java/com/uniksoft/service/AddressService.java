package com.uniksoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniksoft.entity.Address;
import com.uniksoft.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;

	public List<Address> getByCity(String city) {
		return addressRepository.getByCity(city);
	}

}
