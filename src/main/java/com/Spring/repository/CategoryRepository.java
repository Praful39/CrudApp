package com.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
