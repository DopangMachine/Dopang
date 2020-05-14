package com.dopang.spring.boot.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dopang.spring.boot.domain.Product;
import com.dopang.spring.boot.manager.ProductManager;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductManager productManager;
	
	public List<Product> listAll() {

		List<Product> productList = productManager.findAll();
		//sorting product by brand name using java 8
		productList.sort((p1, p2) -> p1.getBrandName().compareTo(p2.getBrandName()));
		
		return productList;
	}
	
	public void save(Product product) {
		productManager.save(product);
	}
	
	public Product get(long id) {
		return productManager.findById(id).get();
	}
	
	public void delete(long id) {
		productManager.deleteById(id);
	}
}
