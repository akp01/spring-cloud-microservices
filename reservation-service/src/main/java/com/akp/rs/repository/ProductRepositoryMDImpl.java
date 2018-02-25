package com.akp.rs.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akp.rs.repository.entity.ProductMD;

@Repository("productRepositoryMD")
public interface ProductRepositoryMDImpl extends CrudRepository<ProductMD, Long> {
	public ProductMD findByName(String name);

	@Query("{type:'?0'}")
	public ProductMD findProductByType(String productType);

}
