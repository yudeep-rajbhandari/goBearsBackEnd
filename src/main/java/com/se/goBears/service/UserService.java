package com.se.goBears.service;

import com.se.goBears.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
