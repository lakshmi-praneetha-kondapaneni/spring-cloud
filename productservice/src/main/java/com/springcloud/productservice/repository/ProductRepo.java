package com.springcloud.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloud.productservice.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
