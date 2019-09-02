package com.spring.mvc.service;

import com.spring.mvc.model.Product;

import java.util.List;

public interface ProductServiceInterface {

    List<Product> get();

    Product store(Product product);

    Product update(Product product);

    void destroy(Long id);

    Long count();
}
