package org.jsp.merchantbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.dao.MerchantDao;
import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.jsp.merchantbootapp.exception.IdNotFoundexception;
import org.jsp.merchantbootapp.exception.InvalidCredentialexception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao merchantDao;

	public ResponseStructure<Merchant> saveMerchant( Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setMeassage("Merchant Saved");
		structure.setData(merchantDao.saveMerchant(merchant));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant) {
		Optional<Merchant> recMerchant =merchantDao.findById(merchant.getId());
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			Merchant dbMerchant = recMerchant.get();
			dbMerchant.setName(merchant.getName());
			dbMerchant.setPhone(merchant.getPhone());
			dbMerchant.setEmail(merchant.getEmail());
			dbMerchant.setGst_number(merchant.getGst_number());
			dbMerchant.setPassword(merchant.getPassword());
			structure.setMeassage("Merchant Updated");
			structure.setData(merchantDao.saveMerchant(merchant));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.ACCEPTED);

		}
		throw new IdNotFoundexception();
	}

	public ResponseEntity<ResponseStructure<Merchant>> finfById( int id) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.findById(id);
		if (recMerchant.isPresent()) {
			structure.setMeassage("Merchant Found");
			structure.setData(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);

		}
   throw new IdNotFoundexception();

	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteById( int id) {
		ResponseStructure<Boolean> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.findById(id);
		if (recMerchant.isPresent()) {
			structure.setMeassage("Merchant deleted");
			structure.setData(true);
			structure.setStatusCode(HttpStatus.OK.value());
			merchantDao.deleteById(id);
			return new ResponseEntity<ResponseStructure<Boolean>>(structure,HttpStatus.OK);

		}
		structure.setMeassage("Merchant Not Found");
		structure.setData(false);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Boolean>>(structure,HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Merchant>>> findall() {
		ResponseStructure<List<Merchant>> structure = new ResponseStructure<>();
		structure.setData(merchantDao.findAll());
		structure.setMeassage("List of Merchants");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Merchant>>>(structure, HttpStatus.ACCEPTED);
	
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(long phone, String password) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.verifyMerchant(phone, password);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMeassage("Merchant Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);

		}
   throw new InvalidCredentialexception("Invalid phone or password");
	}

	public ResponseEntity<ResponseStructure<List<Merchant>>> findByName(String name) {
		ResponseStructure<List<Merchant>> structure = new ResponseStructure<>();
		List<Merchant> products = merchantDao.findByName(name);
		if (products.size() > 0) {
			structure.setData(products);
			structure.setMeassage("Merchants Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Merchant>>>(structure, HttpStatus.OK);
		}
		structure.setMeassage("Merchant Not Found");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Merchant>>>(structure,HttpStatus.NOT_FOUND);

		
	}
	public ResponseEntity<ResponseStructure<Merchant>> findByPhone(long phone) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.finfByPhone(phone);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMeassage("Merchant Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
		}
		structure.setMeassage("Merchant Not Found");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<Merchant>> finfByEmail(String email) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.finfByEmail(email);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMeassage("Merchant Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
		
		}
		structure.setMeassage("Merchant Not Found");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<Merchant>> findByGst(String gst_number) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.findByGst(gst_number);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMeassage("Merchant Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
			
		}
		structure.setMeassage("Merchant Not Found");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant( String email, String password) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.verifyMerchant(email, password);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMeassage("Merchant Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
			
		}
		structure.setMeassage("Merchant Not Found");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(int id, String password) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.verifyMerchant(id, password);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMeassage("Merchant Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
			
		}
		structure.setMeassage("Merchant Not Found");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchantByGstAndPassword(String gst_number, String password) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.verifyMerchantByGstAndPassword(gst_number, password);
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMeassage("Merchant Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
		}
		structure.setMeassage("Merchant Not Found");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.NOT_FOUND);

	}
}
