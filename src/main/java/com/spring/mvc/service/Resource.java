package com.spring.mvc.service;

import com.spring.mvc.model.Product;

import java.util.List;

public interface Resource {

    List<Product> all();

    Product findById(Long id);

    Product store(Product product);

    Product update(Long id, Product product);

    void destroy(Long id);

    Long count();
}
