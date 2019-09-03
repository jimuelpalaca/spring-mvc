package com.spring.mvc.controller.api;

import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsApiController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public List<Product> index(@RequestParam(name = "name", defaultValue = "", required = false) String name) {
        return productService.get(name);
    }
}
