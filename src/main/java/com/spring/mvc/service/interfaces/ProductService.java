package com.spring.mvc.service.interfaces;

import com.spring.mvc.model.Product;

public interface ProductService extends Resource {
    Product store(Product product);

    Product update(Long id, Product product);
}
