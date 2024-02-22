package org.jsp.useraddress.controller;

import java.util.List;

import org.jsp.useraddress.dto.Address;
import org.jsp.useraddress.dto.ResponseStructure;
import org.jsp.useraddress.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class Addresscontroller {
	@Autowired
	private AddressService addressService;

	@PostMapping("/{u_id}")
	public ResponseEntity<ResponseStructure<Address>> saveAddress( @RequestBody Address address, @PathVariable int u_id) {
		return addressService.saveAddress(address, u_id);
	}
	@PutMapping("/{u_id}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address,@PathVariable int u_id) {
		return addressService.updateAddress(address, u_id);
	}
	@GetMapping("/{city}")
	public ResponseEntity<ResponseStructure<List<Address>>> findByCity(@PathVariable String city){
		return addressService.findByCity(city);
	}
	
	@PostMapping("/find-by-user-id")
	public ResponseEntity<ResponseStructure<List<Address>>> findAddressByUserId(@RequestParam int id){
	return addressService.findAddressByUserId(id);
	}
	@PostMapping("/find-by-user-email-password")
	public ResponseEntity<ResponseStructure<List< Address>> >findAddressByUserEmailAndPassword(@RequestParam String email,@RequestParam String password){
	return addressService.findAddressByUserEmailAndPassword(email, password);
	}

}
