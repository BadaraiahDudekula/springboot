package org.jsp.adminuser.exceptions;

public class IdNotFoundException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Invalid Id";
	}

}
