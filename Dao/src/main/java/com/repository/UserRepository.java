package com.repository;

import com.entity.User;

import java.util.Optional;

public interface UserRepository {
    void saveUser(User user);
    Optional<User> getUser(String name);
}
