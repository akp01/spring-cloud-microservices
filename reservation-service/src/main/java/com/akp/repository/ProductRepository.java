package com.akp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.akp.repository.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long>, ProductRepo {
	
	public Product findByName(final String name);

	@Query("{type:'?0'}")
	public Product findProductByType(final String productType);

}
