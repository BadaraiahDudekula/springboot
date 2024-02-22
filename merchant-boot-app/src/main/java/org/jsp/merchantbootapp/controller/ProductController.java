package org.jsp.merchantbootapp.controller;

import java.util.List;

import org.jsp.merchantbootapp.dao.ProductDao;
import org.jsp.merchantbootapp.dto.Product;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.jsp.merchantbootapp.repository.ProductRepository;
import org.jsp.merchantbootapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/{merchant_id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,@PathVariable(name="merchant_id") int merchant_id){
		return productService.saveProduct(product, merchant_id);
	}
	@PutMapping("/{merchant_id}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product, @PathVariable int merchant_id){
		return productService.updateProduct(product,merchant_id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> findById(@PathVariable int id){
		return productService.findById(id);
	}
	@GetMapping("/by-merchant/{m_id}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByMerchantId(@PathVariable int m_id){
	return productService.findByMerchantId(m_id);
	}
	@GetMapping("/by-brand/{brand}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(@PathVariable String brand){
	return productService.findByBrand(brand);
	}
	@GetMapping("/by-catagory/{catagory}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByCatagory(@PathVariable String catagory){
	return productService.findByCatagory(catagory);
	}

}
