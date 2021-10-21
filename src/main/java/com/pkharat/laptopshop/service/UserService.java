package com.pkharat.laptopshop.service;

import com.pkharat.laptopshop.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
