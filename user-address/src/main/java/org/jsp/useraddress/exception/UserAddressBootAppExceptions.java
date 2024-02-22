package org.jsp.useraddress.exception;

import org.jsp.useraddress.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserAddressBootAppExceptions extends RuntimeException {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> INFE(IdNotFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("cannot Find User Id");
		structure.setMessage(e.getMessage());
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> ANFE(AddressNotFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData("cannot Find Address");
		structure.setMessage(e.getMessage());
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
}
