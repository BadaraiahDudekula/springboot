package org.jsp.merchantbootapp.exception;

public class IdNotFoundexception extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invalid Id";
	}

}
