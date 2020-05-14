package com.dopang.spring.boot.service;

import java.util.List;

import com.dopang.spring.boot.domain.Product;

public interface ProductService {

	public List<Product> listAll();

	public void save(Product product);

	public Product get(long id);

	public void delete(long id);
}
