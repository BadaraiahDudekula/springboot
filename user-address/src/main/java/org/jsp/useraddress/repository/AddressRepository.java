package org.jsp.useraddress.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.useraddress.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	//@Query("select a from Address a where city=?1")
	List<Address> findByCity(String city);
	@Query("select u.address from User u where u.id=?1")
	List<Address> findByUserId(int id);
	
	@Query("select u.address from User u where u.email=?1 and u.password=?2")
	List<Address> findByUserEmailPassword(String email, String password);

}















