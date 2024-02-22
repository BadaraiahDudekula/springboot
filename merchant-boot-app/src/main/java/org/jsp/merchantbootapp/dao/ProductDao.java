package org.jsp.merchantbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.dto.Product;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.jsp.merchantbootapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product){
		return productRepository.save(product);
	}
	public Optional<Product> findByid(int id){
		return productRepository.findById(id);
	}
	
	public List<Product> findByMerchantId(int m_id) {
		
		return productRepository.findByMerchantId(m_id);
	}
	public List<Product> findByBrand(String brand) {
		
		return productRepository.findByBrand(brand);
	}
	public List<Product> findBycatagory(String catagory) {
		return productRepository.findByCatagory(catagory);
	}
	
}
