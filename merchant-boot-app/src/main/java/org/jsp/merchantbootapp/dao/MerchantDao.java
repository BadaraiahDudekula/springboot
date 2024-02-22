package org.jsp.merchantbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.jsp.merchantbootapp.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository merchantRepository;

	public Merchant saveMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}
	public Optional<Merchant> findById(int id){
		return merchantRepository.findById(id);
	}
	public List<Merchant> findAll(){
		return merchantRepository.findAll();
	}
	
	public boolean deleteById(int id) {
		Optional<Merchant> recMerchant = findById(id);
		if (recMerchant.isPresent()) {
			merchantRepository.delete(recMerchant.get());
			return true;
		}
		return false;
	}

	public Optional<Merchant> verifyMerchant(long phone, String password) {
		return merchantRepository.verify(phone, password);
	}
	public List<Merchant> findByName(String name) {
		return merchantRepository.findByName(name);
	}
	public Optional<Merchant> finfByPhone(long phone) {
		return merchantRepository.findByPhone(phone);
	}
	public Optional<Merchant> finfByEmail(String email) {
		return merchantRepository.findByEmail(email);
	}
	public Optional<Merchant> findByGst(String gst_number) {
		return merchantRepository.findByGst(gst_number);
	}
	public Optional<Merchant> verifyMerchant( String email, String password) {
		return merchantRepository.verify(email, password);
	}
	public Optional<Merchant> verifyMerchant(int id, String password) {
		return merchantRepository.verify(id, password);
		
	}
	public Optional<Merchant> verifyMerchantByGstAndPassword(String gst_number, String password) {
		return merchantRepository.verify(gst_number, password);
		
	}
}
