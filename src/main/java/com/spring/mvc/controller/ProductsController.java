package com.spring.mvc.controller;

import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @RequestMapping("/")
    public String home() {
        return "redirect:/products";
    }

    @GetMapping("/products")
    public ModelAndView index(@RequestParam(name = "name", defaultValue = "", required = false) String name) {
        List<Product> products = productServiceImpl.searchByNameOrAll(name);

        return new ModelAndView("/products/index", "products", products);
    }

    @GetMapping("/products/create")
    public ModelAndView create(Model model) {
        return new ModelAndView("/products/create", "product", new Product());
    }

    @PostMapping("/products")
    public String store(@ModelAttribute("product") Product product) {
        productServiceImpl.store(product);

        return "redirect:/products";
    }

    @GetMapping("/products/{id}/edit")
    public ModelAndView edit(@PathVariable(name = "id") Long id) {
        return new ModelAndView("products/edit", "product", productServiceImpl.findById(id));
    }

    @PutMapping("/products/{id}")
    public String update(@PathVariable(name = "id") Long id, @ModelAttribute("product") Product productRequest) {
        Product product = productServiceImpl.update(id, productRequest);

        return "redirect:/products/" + product.getId() + "/edit";
    }

    @DeleteMapping("/products/{id}")
    public String destroy(@PathVariable(name = "id") Long id) {
        productServiceImpl.destroy(id);

        return "redirect:/products";
    }
}
