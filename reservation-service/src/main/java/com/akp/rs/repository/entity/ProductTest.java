package com.akp.rs.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

//@Entity(name = "product")
@Document(collection = "product")
public class ProductTest implements Serializable {

	private static final long serialVersionUID = 6551293032874946350L;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;

	//@Column(name = "product_name", nullable = false)
	private String name;

	//@Column(name = "product_type", nullable = false)
	private String type;

	//@Column(name = "expiry_date", nullable = false)
	private String expiryDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	

}
