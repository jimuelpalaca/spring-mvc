package com.spring.mvc.service;

import com.spring.mvc.model.User;
import com.spring.mvc.repository.UserRepository;
import com.spring.mvc.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User store(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        return userRepository.save(user);
    }

    @Override
    public List<?> all() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void destroy(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return null;
    }
}
