package com.spring.mvc.controller;

import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/products";
    }

    @GetMapping("/products")
    public ModelAndView index(@RequestParam(name = "name", defaultValue = "", required = false) String name) {
        List<Product> products = productService.searchByNameOrAll(name);

        return new ModelAndView("/products/index").addObject("products", products);
    }

    @GetMapping("/products/create")
    public String create(Model model) {
        Product product = new Product();

        model.addAttribute("product", product);

        return "products/create";
    }

    @PostMapping("/products")
    public String store(@ModelAttribute("product") Product product) {
        productService.store(product);

        return "redirect:/products";
    }

    @GetMapping("/products/{id}/edit")
    public ModelAndView edit(@PathVariable(name = "id") Long id) {
        Product product = productService.findById(id);

        return new ModelAndView("products/edit").addObject(product);
    }

    @PutMapping("/products/{id}")
    public String update(@PathVariable(name = "id") Long id, @ModelAttribute("product") Product productRequest) {
        Product product = productService.update(id, productRequest);

        return "redirect:/products/" + product.getId() + "/edit";
    }

    @DeleteMapping("/products/{id}")
    public String destroy(@PathVariable(name = "id") Long id) {
        productService.destroy(id);

        return "redirect:/products";
    }
}
