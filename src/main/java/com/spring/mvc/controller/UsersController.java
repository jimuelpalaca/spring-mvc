package com.spring.mvc.controller;

import com.spring.mvc.model.User;
import com.spring.mvc.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public ModelAndView index() {
        return new ModelAndView("users/index", "users", userService.all());
    }

    @GetMapping("users/create")
    public ModelAndView create() {
        return new ModelAndView("users/create", "user", new User());
    }

    @PostMapping("users")
    public String store(@ModelAttribute("user") User user) {
        userService.store(user);

        return "redirect:/users";
    }

}