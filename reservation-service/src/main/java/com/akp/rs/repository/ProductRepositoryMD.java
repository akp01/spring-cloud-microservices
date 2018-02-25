package com.akp.rs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.akp.rs.repository.entity.ProductMD;

@Repository("productRepositoryMD")
public interface ProductRepositoryMD extends MongoRepository<ProductMD, Long>, ProductRepo {
	
	public ProductMD findByName(String name);

	@Query("{type:'?0'}")
	public ProductMD findProductByType(String productType);

}
