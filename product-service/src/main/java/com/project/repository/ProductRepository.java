package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
