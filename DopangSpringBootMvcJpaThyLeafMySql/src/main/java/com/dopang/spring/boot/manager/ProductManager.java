package com.dopang.spring.boot.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dopang.spring.boot.domain.Product;

public interface ProductManager extends JpaRepository<Product, Long>{

}
