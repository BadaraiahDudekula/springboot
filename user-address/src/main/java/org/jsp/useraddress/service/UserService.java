package org.jsp.useraddress.service;

import java.util.Optional;

import org.jsp.useraddress.dao.UserDao;
import org.jsp.useraddress.dto.ResponseStructure;
import org.jsp.useraddress.dto.User;
import org.jsp.useraddress.exception.IdNotFoundException;
import org.jsp.useraddress.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDao ud;
	
	public ResponseStructure<User> saveUser(User u){
		ResponseStructure<User> rs=new ResponseStructure<>();
		rs.setMessage("user saved");
		rs.setData(u);
		rs.setHttpStatus(HttpStatus.CREATED.value());
		ud.saveUser(u);
		return rs;
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User u){
		ResponseStructure<User> rs=new ResponseStructure<>();
		Optional<User> op=ud.findById(u.getId());
		if(op.isPresent()) {
		rs.setMessage("user updated");
		rs.setData(ud.saveUser(u));
		rs.setHttpStatus(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<User>> findById(int id){
		ResponseStructure<User> rs=new ResponseStructure<>();
		Optional<User> op=ud.findById(id);
		if(op.isPresent()) {
		rs.setMessage("user found with Id");
		rs.setData(op.get());
		rs.setHttpStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone, String password) {
		Optional<User> user = ud.verify(phone, password);
		ResponseStructure<User> rs = new ResponseStructure<>();
		if (user.isPresent()) {
			rs.setMessage("Verification Succesfull");
			rs.setData(user.get());
			rs.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.OK);
		}
		throw new UserNotFoundException("Invalid phone or Password");
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(String email, String password) {
		Optional<User> user = ud.verify(email, password);
		ResponseStructure<User> rs = new ResponseStructure<>();
		if (user.isPresent()) {
			rs.setMessage("Verification Succesfull");
			rs.setData(user.get());
			rs.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.OK);
		}
		throw new UserNotFoundException("Invalid email or Password");
	}
	
	
	

	
	

}





