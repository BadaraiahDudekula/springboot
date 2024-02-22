package org.jsp.useraddress.service;

import java.util.List;
import java.util.Optional;

import org.jsp.useraddress.dao.AddressDao;
import org.jsp.useraddress.dao.UserDao;
import org.jsp.useraddress.dto.Address;
import org.jsp.useraddress.dto.ResponseStructure;
import org.jsp.useraddress.dto.User;
import org.jsp.useraddress.exception.AddressNotFoundException;
import org.jsp.useraddress.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	private AddressDao ad;
	@Autowired
	private UserDao ud;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address, int u_id) {
		Optional<User> op = ud.findById(u_id);
		ResponseStructure<Address> rs= new ResponseStructure<>();
		if (op.isPresent()) {
			User u=op.get();
			u.getAddress().add(address);
			address.setUser(u);
			rs.setData(ad.saveAddress(address));
			rs.setMessage("Address added");
			rs.setHttpStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Address>>(rs, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address,int u_id) {
		Optional<User> op = ud.findById(u_id);
		Optional<Address> adr = ad.findById(address.getId());
		ResponseStructure<Address> rs= new ResponseStructure<>();
		if (adr.isPresent()) {
			User u=op.get();
			u.getAddress().add(address);
			address.setUser(u);
			rs.setData(ad.saveAddress(address));
			rs.setMessage("Address updated");
			rs.setHttpStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Address>>(rs, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List< Address>>> findByCity(String city){
		List<Address> a=ad.findByCity(city);
		ResponseStructure<List<Address>> rs=new ResponseStructure<>();
		if(a.size()>0) {
			rs.setMessage("Address details found with city");
			rs.setData(a);
			rs.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Address>>>(rs, HttpStatus.OK);
		}
		throw new AddressNotFoundException("Address Not found with the City Name");
	}
	
	public ResponseEntity<ResponseStructure<List< Address>> >findAddressByUserId(int id){
		List< Address> a=ad.findAddressByUserId(id);
		ResponseStructure<List<Address>> rs=new ResponseStructure<>();
		if(a.size()>0) {
			rs.setMessage("Address details found with User Id");
			rs.setData(a);
			rs.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List< Address>>>(rs, HttpStatus.OK);
		}
		throw new AddressNotFoundException("Address Not found with the User Id");
	}
	public ResponseEntity<ResponseStructure<List< Address>> >findAddressByUserEmailAndPassword(String email,String password){
		List< Address> a=ad.findAddressByUserEmailAndPassword(email, password);
		ResponseStructure<List<Address>> rs=new ResponseStructure<>();
		if(a.size()>0) {
			rs.setMessage("Address details found ");
			rs.setData(a);
			rs.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List< Address>>>(rs, HttpStatus.OK);
		}
		throw new AddressNotFoundException("Address Not found with the User Email and Password");
	}
	


}





