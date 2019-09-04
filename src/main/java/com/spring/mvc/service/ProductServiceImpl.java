package com.spring.mvc.service;

import com.spring.mvc.model.Product;
import com.spring.mvc.model.User;
import com.spring.mvc.repository.ProductRepository;
import com.spring.mvc.repository.UserRepository;
import com.spring.mvc.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Product> all() {
        return productRepository.findAll();
    }

    public List<Product> searchByNameOrAll(String name) {
        if (! name.equals("")) {
            return productRepository.searchByName(name);
        }

        return this.all();
    }

    @Override
    public Product findById(Long id){
        return productRepository.findById(id).get();
    }

    @Override
    public Product store(Product product) {
        Instant now = Instant.now();
        Long id = new Long(1);
        User user = userRepository.findById(id).get();

        product.setUser(user);
        product.setCreated_at(now);
        product.setUpdated_at(now);
        productRepository.save(product);

        return product;
    }

    @Override
    public Product update(Long id, Product productRequest) {
        Product product = productRepository.findById(id).get();

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setCreated_at(product.getCreated_at());
        product.setUpdated_at(Instant.now());

        productRepository.save(product);

        return product;
    }

    @Override
    public void destroy(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return null;
    }
}
