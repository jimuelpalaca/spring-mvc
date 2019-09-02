package com.spring.mvc.controller;

import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/products";
    }

    @RequestMapping(name = "/products", method = RequestMethod.GET)
    public String index(Model model) {
        List<Product> products = productService.get();

        model.addAttribute("products", products);

        return "products/index";
    }

    @RequestMapping("/products/create")
    public String create(Model model) {
        Product product = new Product();

        model.addAttribute("product", product);

        return "products/create";
    }

    @RequestMapping(name = "/products", method = RequestMethod.POST)
    public String store(@ModelAttribute("product") Product product) {
        productService.store(product);

        return "redirect:/products/create";
    }
}
