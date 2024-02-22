package org.jsp.merchantbootapp.exception;

import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class MerchantBootAppExceptionHandler extends RuntimeException {
	@ExceptionHandler(InvalidCredentialexception.class)
	public ResponseEntity<ResponseStructure<String>> handleICE(InvalidCredentialexception exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData("Cannot Find Merchant");
		structure.setMeassage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(IdNotFoundexception.class)
	public ResponseEntity<ResponseStructure<String>> handleINE(IdNotFoundexception exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData("Cannot Find Merchant");
		structure.setMeassage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handlePNFE(ProductNotFoundException exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData("Invalid Id");
		structure.setMeassage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
