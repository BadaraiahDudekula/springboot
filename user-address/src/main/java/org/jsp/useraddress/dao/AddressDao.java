package org.jsp.useraddress.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.useraddress.dto.Address;
import org.jsp.useraddress.dto.User;
import org.jsp.useraddress.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao {
	
	@Autowired
	private AddressRepository ar;
	
	public Address saveAddress(Address address) {
		return ar.save(address);
	}
	
	public Optional<Address> findById(int id) {
		return ar.findById(id);
	}
	
	public List<Address> findByCity(String city) {
		return ar.findByCity(city);
	}
	public List<Address> findAddressByUserId(int id) {
		return ar.findByUserId(id);
	}
	
	public List<Address> findAddressByUserEmailAndPassword(String email,String password) {
		return ar.findByUserEmailPassword(email,password);
	}
	

}
