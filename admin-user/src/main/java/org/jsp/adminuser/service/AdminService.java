package org.jsp.adminuser.service;


import java.util.Optional;

import org.jsp.adminuser.dao.Admindao;
import org.jsp.adminuser.dto.Admin;
import org.jsp.adminuser.dto.ResponseStructure;
import org.jsp.adminuser.exceptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class AdminService {
	@Autowired
	private Admindao adminDao;
	
	public ResponseStructure<Admin> saveAdmin(Admin admin){
		ResponseStructure<Admin> rs=new ResponseStructure<>();
		rs.setMessage("admin saved");
		rs.setData(adminDao.saveAdmin(admin));
		rs.setStatusCode(HttpStatus.CREATED.value());
		return rs;
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin){
		ResponseStructure<Admin> rs=new ResponseStructure<>();
		Optional<Admin> ad=adminDao.findById(admin.getId());
		if(ad.isPresent()) {
		rs.setMessage("admin update");
		rs.setData(adminDao.saveAdmin(admin));
		rs.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(rs, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Admin>> findById(int id){
		ResponseStructure<Admin> rs=new ResponseStructure<>();
		Optional<Admin> ad=adminDao.findById(id);
		if(ad.isPresent()) {
			rs.setMessage("admin details fetched");
			rs.setData(ad.get());
			rs.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(rs, HttpStatus.OK);
		}
		return  null;
	}
	public ResponseEntity<ResponseStructure<Boolean>> deleteById(int id){
		Optional<Admin> ad=adminDao.findById(id);
		ResponseStructure<Boolean> rs=new ResponseStructure<>();
		if(ad.isPresent()) {
			rs.setData(true);
			rs.setMessage("admin deleted");
			rs.setStatusCode(HttpStatus.OK.value());
			adminDao.deleteById(id);
			return new ResponseEntity<ResponseStructure<Boolean>>(rs, HttpStatus.OK);
		}
		return null;
	}

	
	
}
