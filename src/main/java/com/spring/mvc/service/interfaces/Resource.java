package com.spring.mvc.service.interfaces;

import com.spring.mvc.model.Model;
import com.spring.mvc.model.Product;

import java.util.List;

public interface Resource {

    List<?> all();

    Model findById(Long id);

    void destroy(Long id);

    Long count();
}
