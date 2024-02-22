package org.jsp.useraddress.controller;

import org.jsp.useraddress.dto.ResponseStructure;
import org.jsp.useraddress.dto.User;
import org.jsp.useraddress.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseStructure<User> saveUser(@RequestBody User u){
	return userService.saveUser(u);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User u){
	return userService.updateUser(u);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable int id){
	return userService.findById(id);
	}
	
	@PostMapping("/verify-phone-password")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam long phone,  String password) {
	return userService.verifyUser(phone, password);
	}
	
	@PostMapping("/verify-email-password")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam String email,  String password) {
	return userService.verifyUser(email, password);
	}
	
	
	

}
