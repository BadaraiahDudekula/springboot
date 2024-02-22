package org.jsp.useraddress.dao;

import java.util.Optional;

import org.jsp.useraddress.dto.User;
import org.jsp.useraddress.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository ur;
	
	public User saveUser(User user) {
		return ur.save(user);
	}
	public Optional<User> findById(int id) {
		return ur.findById(id);
	}
	public Optional<User> verify(long phone,String password) {
		return ur.verify(phone,password);
	}
	
	public Optional<User> verify(String email,String password) {
		return ur.verify(email,password);
	}
	
	

}
