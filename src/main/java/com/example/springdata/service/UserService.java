package com.example.springdata.service;

import com.example.springdata.domain.model.User;

public interface UserService {
    /**
     * @param username username.
     * @return user for given username.
     */
    User findByUsername(String username);

    /**
     * @param user user object to save.
     * @return saved user object.
     */
    User save(User user);
}
