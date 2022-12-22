package com.uniksoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uniksoft.entity.Address;
import com.uniksoft.entity.Student;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	//*** Go for Method proxy as much as possible
	// JPA Method proxy
	//List<Address> findByAddressCity(String city);
	
	// JPQL
	@Query("From Address where city = :city")
	List<Address> getByCity(String city);
}
