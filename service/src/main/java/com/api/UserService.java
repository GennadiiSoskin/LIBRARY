package com.api;

import com.entity.Book;
import com.entity.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserService {

    boolean save(User user);

    Page<User> findAll(int pageIndex);

    Optional<User> findByName(String name);
}
