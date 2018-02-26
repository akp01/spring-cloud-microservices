package com.akp.repository;

import org.springframework.stereotype.Component;

import com.akp.repository.entity.Product;

@Component
public class ProductRepoImpl implements ProductRepo {

	@Override
	public Product findProductsByNameAsc() {
		return null;
	}

}
