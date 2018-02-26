/**
 * 
 */
package com.akp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.akp.repository.ProductRepository;
import com.akp.repository.entity.Product;

@RestController
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	/*@Autowired
	ProductRepository productRepository;*/
	
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {

//		List<Product> products = productRepository.findAll();
		List<Product> products = (List<Product>) productRepository.findAll();
		ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);

		return response;
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId) {

		Product product = null;
		try {
			product = productRepository.findByName("product4");
		} catch (Exception e) {
			logger.error("Exception : " + e);
		}
		ResponseEntity<Product> response = new ResponseEntity<>(product, HttpStatus.OK);

		return response;
	}
	
	@GetMapping("/product/{productName}")
	public ResponseEntity<Product> getProductByName(@PathVariable("productName") Long productName) {

		Product product = null;
		try {
			product = productRepository.findByName("product4");
		} catch (Exception e) {
			logger.error("Exception : " + e);
		}
		ResponseEntity<Product> response = new ResponseEntity<>(product, HttpStatus.OK);

		return response;
	}
	
	@GetMapping("/product/{productType}")
	public ResponseEntity<?> getProductByType(@PathVariable("productType") String productType) {

		Product product = null;
		ResponseEntity<?> response = null;

		try {
			product = productRepository.findProductByType(productType);
			response = new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception : " + e);
			response = new ResponseEntity<String>("Exception Occurred : ", HttpStatus.NOT_FOUND);
		}
		return response;
	}

}
