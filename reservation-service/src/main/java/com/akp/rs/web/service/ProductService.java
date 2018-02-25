/**
 * 
 */
package com.akp.rs.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.akp.rs.repository.ProductRepositoryMD;
import com.akp.rs.repository.entity.ProductMD;


@RestController
public class ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	/*@Autowired
	ProductRepository productRepository;*/
	
	@Autowired
	ProductRepositoryMD productRepositoryMD;

	@GetMapping("/products")
	public ResponseEntity<List<ProductMD>> getProducts() {

//		List<Product> products = productRepository.findAll();
		List<ProductMD> products = (List<ProductMD>) productRepositoryMD.findAll();
		ResponseEntity<List<ProductMD>> response = new ResponseEntity<>(products, HttpStatus.OK);

		return response;
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<ProductMD> getProductById(@PathVariable("id") Long productId) {

		ProductMD product = null;
		try {
			product = productRepositoryMD.findByName("product4");
		} catch (Exception e) {
			logger.error("Exception : " + e);
		}
		ResponseEntity<ProductMD> response = new ResponseEntity<>(product, HttpStatus.OK);

		return response;
	}
	
	@GetMapping("/product/{productName}")
	public ResponseEntity<ProductMD> getProductByName(@PathVariable("productName") Long productName) {

		ProductMD product = null;
		try {
			product = productRepositoryMD.findByName("product4");
		} catch (Exception e) {
			logger.error("Exception : " + e);
		}
		ResponseEntity<ProductMD> response = new ResponseEntity<>(product, HttpStatus.OK);

		return response;
	}
	
	@GetMapping("/product/{productType}")
	public ResponseEntity<?> getProductByType(@PathVariable("productType") String productType) {

		ProductMD product = null;
		ResponseEntity<?> response = null;

		try {
			product = productRepositoryMD.findProductByType(productType);
			response = new ResponseEntity<ProductMD>(product, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception : " + e);
			response = new ResponseEntity<String>("Exception Occurred : ", HttpStatus.NOT_FOUND);
		}
		return response;
	}

}
