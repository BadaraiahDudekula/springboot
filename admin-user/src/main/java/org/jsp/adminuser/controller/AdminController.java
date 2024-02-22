package org.jsp.adminuser.controller;

import org.jsp.adminuser.dto.Admin;
import org.jsp.adminuser.dto.ResponseStructure;
import org.jsp.adminuser.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseStructure<Admin> save(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>> update(@RequestBody Admin admin) {
		return adminService.updateAdmin(admin);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findById(@PathVariable int id){
	return adminService.findById(id);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Boolean>> deleteById(@PathVariable int id){
	return adminService.deleteById(id);
	}
	
}
