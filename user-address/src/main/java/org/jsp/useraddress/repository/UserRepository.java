package org.jsp.useraddress.repository;

import java.util.Optional;

import org.jsp.useraddress.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.phone=?1 and u.password=?2")
	Optional<User> verify(long phone, String password);
	@Query("select u from User u where u.email=?1 and u.password=?2")
	Optional<User> verify(String email, String password);

}





