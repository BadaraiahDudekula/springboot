package org.jsp.merchantbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.dao.MerchantDao;
import org.jsp.merchantbootapp.dao.ProductDao;
import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.Product;
import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.jsp.merchantbootapp.exception.IdNotFoundexception;
import org.jsp.merchantbootapp.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private MerchantDao merchantDao;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product,int merchant_id){
		Optional<Merchant> recMerchant=merchantDao.findById(merchant_id);
		ResponseStructure<Product> rs=new ResponseStructure<>();
		if(recMerchant.isPresent()) {
			Merchant merchant=recMerchant.get();
			merchant.getProducts().add(product);
			product.setMerchant(merchant);
			rs.setData(productDao.saveProduct(product));
			rs.setMeassage("Product Saved");
			rs.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(rs, HttpStatus.CREATED);
		}
		throw new IdNotFoundexception();
	}
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product,int merchant_id){
		Optional<Merchant> recMerchant=merchantDao.findById(merchant_id);
		Optional<Product> recProduct=productDao.findByid(product.getId());
		ResponseStructure<Product> rs=new ResponseStructure<>();
		if(recProduct.isPresent()) {
			Merchant merchant=recMerchant.get();
			merchant.getProducts().add(product);
			product.setMerchant(merchant);
			Product p=recProduct.get();
			p.setBrand(product.getBrand());
			p.setCatagory(product.getCatagory());
			p.setCost(product.getCost());
			p.setDescription(product.getDescription());
			p.setName(product.getName());
			p.setUrl(product.getUrl());
			rs.setData(productDao.saveProduct(product));
			rs.setMeassage("Product Saved");
			rs.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Product>>(rs, HttpStatus.ACCEPTED);
		}
		throw new ProductNotFoundException("Cannot Update Product As Invalid Id");
	}
	
	public ResponseEntity<ResponseStructure<Product>> findById(int id){
		Optional<Product> recProduct=productDao.findByid(id);
		ResponseStructure<Product> rs=new ResponseStructure<>();
		if(recProduct.isPresent()) {
			rs.setData(recProduct.get());
			rs.setMeassage("Product Saved");
			rs.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(rs, HttpStatus.OK);
		}
		throw new ProductNotFoundException("Invalid Product Id");
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> findByMerchantId(int m_id){
		List<Product> products=productDao.findByMerchantId(m_id);
		ResponseStructure<List<Product>> rs=new ResponseStructure<>();
		if(products.size()>0) {
			rs.setData(products);
			rs.setMeassage("Product Saved");
			rs.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Product>>>(rs, HttpStatus.OK);
		
		}
		throw new ProductNotFoundException("Invalid Product Id");
		
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(String brand){
		List<Product> products=productDao.findByBrand(brand);
		ResponseStructure<List<Product>> rs=new ResponseStructure<>();
		if(products.size()>0) {
			rs.setData(products);
			rs.setMeassage("Product");
			rs.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Product>>>(rs, HttpStatus.OK);
		
		}
		throw new ProductNotFoundException("No Product found for this Brand");
	}
	public ResponseEntity<ResponseStructure<List<Product>>> findByCatagory(String catagory){
		List<Product> products=productDao.findBycatagory(catagory);
		ResponseStructure<List<Product>> rs=new ResponseStructure<>();
		if(products.size()>0) {
			rs.setData(products);
			rs.setMeassage("Products List");
			rs.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Product>>>(HttpStatus.OK);
		}
		throw new ProductNotFoundException("No product for this catagory");
	}


}
