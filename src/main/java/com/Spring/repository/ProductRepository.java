package com.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
