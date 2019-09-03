package com.spring.mvc.repository;

import com.spring.mvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products WHERE name LIKE %?% ", nativeQuery = true)
    List<Product> searchByName(String name);
}
