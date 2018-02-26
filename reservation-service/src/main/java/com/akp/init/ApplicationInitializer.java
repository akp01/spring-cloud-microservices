package com.akp.init;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.akp.repository.ProductRepository;
import com.akp.repository.entity.Product;
import com.akp.repository.entity.ProductJP;

@Component
public class ApplicationInitializer implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

	// @Autowired
	// ProductRepository productRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		// productRepository.save(getMockProductsJP());

		List<Product> products = (List<Product>) productRepository.findAll();

		/*
		 * if (!StringUtils.isEmpty(products) && !products.isEmpty()) {
		 * productRepository.deleteAll(); }
		 */

		// productRepository.save(getMockProductsMD());
		products.stream().forEach(product -> productRepository.delete(product));
		getMockProductsMD().stream().forEach(product -> productRepository.save(product));

		productRepository.findAll().stream().forEach(product -> {
			System.out.println(product.getProductId());
			System.out.println(product.getName());
			System.out.println(product.getType());
			System.out.println(product.getExpiryDate());
		});
		logger.info(
				"Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.",
				Arrays.toString(args));
	}

	private List<ProductJP> getMockProductsJP() {

		List<ProductJP> products = new ArrayList<>();
		final LocalDateTime currentDateTime = LocalDateTime.now();
		products.add(getProduct("product1", "type1", currentDateTime));
		products.add(getProduct("product2", "type2", currentDateTime));
		products.add(getProduct("product3", "type3", currentDateTime));
		products.add(getProduct("product4", "type4", currentDateTime));
		products.add(getProduct("product5", "type5", currentDateTime));
		products.add(getProduct("product6", "type6", currentDateTime));
		return products;
	}

	private ProductJP getProduct(final String name, final String type, final LocalDateTime currentDateTime) {
		final ProductJP product = new ProductJP();
		product.setName(name);
		product.setType(type);
		product.setExpiryDate(currentDateTime.toString());
		return product;
	}

	private List<Product> getMockProductsMD() {
		List<Product> products = new ArrayList<>();
		final LocalDateTime currentDateTime = LocalDateTime.now();
		products.add(getProduct(101L, "product1", "type1", currentDateTime));
		products.add(getProduct(102L, "product2", "type2", currentDateTime));
		products.add(getProduct(103L, "product3", "type3", currentDateTime));
		products.add(getProduct(104L, "product4", "type4", currentDateTime));
		products.add(getProduct(105L, "product5", "type5", currentDateTime));
		products.add(getProduct(106L, "product6", "type6", currentDateTime));
		products.add(getProduct(107L, "product7", "type7", currentDateTime));
		return products;
	}

	private Product getProduct(final Long productId, final String name, final String type, final LocalDateTime currentDateTime) {
		final Product product = new Product();
		product.setProductId(productId);
		product.setName(name);
		product.setType(type);
		product.setExpiryDate(currentDateTime.toString());
		return product;
	}
}