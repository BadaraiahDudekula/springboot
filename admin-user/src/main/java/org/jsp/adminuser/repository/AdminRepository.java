package org.jsp.adminuser.repository;

import org.jsp.adminuser.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
}
