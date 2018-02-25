package com.akp.rs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.akp.rs.repository.entity.ProductMD;

@Repository
public interface ProductRepositoryMDRepo extends MongoRepository<ProductMD, Long> {
	public ProductMD findByName(String name);

	@Query("{type:'?0'}")
	public ProductMD findProductByType(String productType);

}
