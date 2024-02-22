package org.jsp.adminuser.exceptions;

import org.jsp.adminuser.dto.Admin;
import org.jsp.adminuser.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdminUserApplication extends RuntimeException {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> INE(IdNotFoundException exception){
		
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData("Cannot Find Admin");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(HttpStatus.NOT_FOUND);
	}
	
}
