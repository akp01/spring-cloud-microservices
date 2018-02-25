package com.akp.rs.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.akp.rs.repository.ProductRepositoryMD;
import com.akp.rs.repository.entity.ProductJP;
import com.akp.rs.repository.entity.ProductMD;

@Component
public class ApplicationInitializer implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

	// @Autowired
	// ProductRepository productRepository;

	@Autowired
	private ProductRepositoryMD productRepositoryMD;

	@Override
	public void run(String... args) throws Exception {

		// productRepository.save(getMockProductsJP());

		List<ProductMD> products = (List<ProductMD>) productRepositoryMD.findAll();

		if (!StringUtils.isEmpty(products) && !products.isEmpty()) {
			productRepositoryMD.deleteAll();
		}
		productRepositoryMD.save(getMockProductsMD());
		logger.info(
				"Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.",
				Arrays.toString(args));
	}

	private List<ProductJP> getMockProductsJP() {

		List<ProductJP> products = new ArrayList<>();

		ProductJP product = new ProductJP();
		product.setName("product1");
		product.setType("type1");
		product.setExpiryDate(new Date().toString());
		products.add(product);

		ProductJP product1 = new ProductJP();
		product1.setName("product2");
		product1.setType("type2");
		product1.setExpiryDate(new Date().toString());
		products.add(product1);

		ProductJP product3 = new ProductJP();
		product3.setName("product3");
		product3.setType("type3");
		product3.setExpiryDate(new Date().toString());
		products.add(product3);

		ProductJP product4 = new ProductJP();
		product4.setName("product4");
		product4.setType("type4");
		product4.setExpiryDate(new Date().toString());
		products.add(product4);

		ProductJP product5 = new ProductJP();
		product5.setName("product5");
		product5.setType("type5");
		product5.setExpiryDate(new Date().toString());
		products.add(product5);

		ProductJP product6 = new ProductJP();
		product6.setName("product6");
		product6.setType("type6");
		product6.setExpiryDate(new Date().toString());
		products.add(product6);

		return products;
	}

	private List<ProductMD> getMockProductsMD() {

		List<ProductMD> products = new ArrayList<>();

		ProductMD product1 = new ProductMD();
		product1.setProductId(101L);
		product1.setName("product1");
		product1.setType("type1");
		product1.setExpiryDate(new Date().toString());
		products.add(product1);

		ProductMD product2 = new ProductMD();
		product2.setProductId(102L);
		product2.setName("product2");
		product2.setType("type2");
		product2.setExpiryDate(new Date().toString());
		products.add(product2);

		ProductMD product3 = new ProductMD();
		product3.setProductId(103L);
		product3.setName("product3");
		product3.setType("type3");
		product3.setExpiryDate(new Date().toString());
		products.add(product3);

		ProductMD product4 = new ProductMD();
		product4.setProductId(104L);
		product4.setName("product4");
		product4.setType("type4");
		product4.setExpiryDate(new Date().toString());
		products.add(product4);

		ProductMD product5 = new ProductMD();
		product5.setProductId(105L);
		product5.setName("product5");
		product5.setType("type5");
		product5.setExpiryDate(new Date().toString());
		products.add(product5);

		ProductMD product6 = new ProductMD();
		product6.setProductId(106L);
		product6.setName("product6");
		product6.setType("type6");
		product6.setExpiryDate(new Date().toString());
		products.add(product6);

		ProductMD product7 = new ProductMD();
		product7.setProductId(107L);
		product7.setName("product7");
		product7.setType("type7");
		product7.setExpiryDate(new Date().toString());
		products.add(product7);

		return products;
	}
}