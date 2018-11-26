package com.vaibhavsood.business.service;

import com.vaibhavsood.data.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
