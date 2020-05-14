package com.dopang.spring.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product", schema = "dopang")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID", insertable = true, nullable = false, unique = true)
	private Long productId;
	
	@Column(name = "PRODUCT_NAME", insertable = true, unique = false, nullable = true)
	private String productName;
	
	@Column(name = "BRAND_NAME", insertable = true, unique = false, nullable = true)
	private String brandName;
	
	@Column(name = "MADE_IN_COUNTRY", insertable = true, unique = false, nullable = true)
	private String madeIn;
	
	@Column(name = "PRODUCT_PRICE", insertable = true, unique = false, nullable = true)
	private float productPrice;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getMadeIn() {
		return madeIn;
	}

	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
}
