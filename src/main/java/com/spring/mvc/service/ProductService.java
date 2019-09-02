package com.spring.mvc.service;

import com.spring.mvc.model.Product;
import com.spring.mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> get() {
        return productRepository.findAll();
    }

    @Override
    public Product store(Product product) {
        Instant now = Instant.now();

        product.setCreated_at(now);
        product.setUpdated_at(now);
        productRepository.save(product);

        return product;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void destroy(Long id) {

    }

    @Override
    public Long count() {
        return null;
    }
}
