package com.akp.rs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akp.rs.repository.entity.ProductJP;

@Repository
public interface ProductRepositoryJP extends CrudRepository<ProductJP, Long> {

	public List<ProductJP> findAll();

	public List<ProductJP> findByName(String name);

}
