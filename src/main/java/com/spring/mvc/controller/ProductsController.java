package com.spring.mvc.controller;

import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String index(Model model) {
        List<Product> products = productService.get();

        model.addAttribute("products", products);

        return "products/index";
    }

    @RequestMapping(name = "/products/create", method = RequestMethod.GET)
    public String create(Model model) {
        Product product = new Product();

        model.addAttribute("product", product);

        return "products/create";
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String store(@ModelAttribute("product") Product product) {
        productService.store(product);

        return "redirect:/products";
    }

    @RequestMapping(value = "/products/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(name = "id") Long id) {
        Product product = productService.findById(id);

        return new ModelAndView("products/edit").addObject(product);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable(name = "id") Long id, @ModelAttribute("product") Product productRequest) {
        Product product = productService.update(id, productRequest);

        return "redirect:/products/" + product.getId() + "/edit";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable(name = "id") Long id) {
        productService.destroy(id);

        return "redirect:/products";
    }
}
