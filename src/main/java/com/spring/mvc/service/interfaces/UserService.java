package com.spring.mvc.service.interfaces;

import com.spring.mvc.model.User;

public interface UserService extends Resource {
    User store(User user);

    User update(Long id, User user);
}
