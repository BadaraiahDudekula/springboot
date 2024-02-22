package org.jsp.merchantbootapp.repository;

import java.util.List;

import org.jsp.merchantbootapp.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("select m.products from Merchant m where m.id=?1 ")
	public List<Product> findByMerchantId(int m_id);
	public List<Product> findByBrand(String brand);
	public List<Product> findByCatagory(String catagory);
}
