package com.impl;

import com.api.UserService;
import com.entity.User;
import com.repository.UserJpaRepository;
import com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserJpaRepository userJpaRepository;
    private final UserRepository userRepository;
    @Override
    public boolean save(User user) {
        if (userJpaRepository.findUserByName(user.getName()).isPresent())
        {
            return false;
        }
        else {
            userRepository.saveUser(user);
            return true;
        }

    }

    @Override
    public Page<User> findAll(int pageIndex) {
        int pageSize = 15;
        return userJpaRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    @Override
    public Optional<User> findByName(String name) {
        return userJpaRepository.findUserByName(name);
    }
}
