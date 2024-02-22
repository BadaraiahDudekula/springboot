package org.jsp.merchantbootapp.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.jsp.merchantbootapp.repository.MerchantRepository;
import org.jsp.merchantbootapp.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/merchants")
public class MerchantController {
	@Autowired
	private MerchantService merchantService;

	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseStructure<Merchant> saveMerchant(@RequestBody Merchant merchant) {

		return merchantService.saveMerchant(merchant);
	}

	@PutMapping
	private ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
		return merchantService.updateMerchant(merchant);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> finfById(@PathVariable(name = "id") int id) {
		return merchantService.finfById(id);	
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<Boolean>> deleteById(@PathVariable(name = "id") int id) {
		return merchantService.deleteById(id);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Merchant>>> findall() {
		return merchantService.findall();
	}

	@PostMapping("/verify-by-phone-password")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam long phone, String password) {
		return merchantService.verifyMerchant(phone, password);
	}

	@GetMapping("/find-by-name/{name}")
	public ResponseEntity<ResponseStructure<List<Merchant>>> findByName(@PathVariable String name) {
		return merchantService.findByName(name);
	}

	@GetMapping(value = "/find-by-phone/{phone}")
	public ResponseEntity<ResponseStructure<Merchant>> finfByPhone(@PathVariable(name = "phone") long phone) {
		return merchantService.findByPhone(phone);
	}

	@GetMapping(value = "/find-by-email/{email}")
	public ResponseEntity<ResponseStructure<Merchant>> finfByEmail(@PathVariable(name = "email") String email) {

		return merchantService.finfByEmail(email);
	}

	@GetMapping(value = "/find-by-gst/{gst_name}")
	public ResponseEntity<ResponseStructure<Merchant>> findByGst(@PathVariable(name = "gst_name") String gst_number) {
		return merchantService.findByGst(gst_number);
	}

	@PostMapping("/verify-by-email-password")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam String email, String password) {

		return merchantService.verifyMerchant(email, password);
	}

	@PostMapping("/verify-by-id-password")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam int id, String password) {

		return merchantService.verifyMerchant(id, password);
	}

	@PostMapping("/verify-by-gst-password")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchantByGstAndPassword(@RequestParam String gst_number, String password) {

		return merchantService.verifyMerchantByGstAndPassword(gst_number, password);
	}

}
