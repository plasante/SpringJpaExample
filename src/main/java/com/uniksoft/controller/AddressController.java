package com.uniksoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniksoft.entity.Address;
import com.uniksoft.response.AddressResponse;
import com.uniksoft.service.AddressService;

@RestController
@RequestMapping("/api/address/")
public class AddressController {
	
	@Autowired AddressService addressService;

	Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	@GetMapping("get")
	public AddressResponse getAddresses() {

		logger.error("Inside Error");
		logger.warn("Inside Warning");
		logger.info("Inside Info");
		logger.debug("Inside Debug");
		logger.trace("Inside Trace");

		AddressResponse addressResponse = new AddressResponse(1, "Sainte-Marie", "Mascouche");
		return addressResponse;
	}
	
	@GetMapping("/getByCity/{city}")
	public List<AddressResponse> getByFirstName(@PathVariable String city) {
		List<Address> adressList = addressService.getByCity(city);
		
		List<AddressResponse> addressResponseList = new ArrayList<>();
		
		adressList.stream().forEach(address -> {
			addressResponseList.add(new AddressResponse(address));
		});
		
		return addressResponseList;
	}
	

	
}
