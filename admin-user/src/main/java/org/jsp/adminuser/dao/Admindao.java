package org.jsp.adminuser.dao;

import java.util.Optional;

import org.jsp.adminuser.dto.Admin;
import org.jsp.adminuser.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Admindao {
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		return  adminRepository.save(admin);
	}

	public Optional<Admin> findById(int id) {
		return adminRepository.findById(id);
	}
	
	public Boolean deleteById(int id) {
		Optional<Admin> ad=findById(id);
		if(ad.isPresent()) {
			adminRepository.deleteById(id);
			return true;
		}return false;
	}

	

}
