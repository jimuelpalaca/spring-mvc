package com.spring.mvc.repository;

import com.spring.mvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByName(String name);
}
