package com.impl;


import com.api.CustomUserService;
import com.entity.User;
import com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomUserServiceImpl implements CustomUserService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User loadedUser = repository.findUserByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find user by provided name!"));

        return new org.springframework.security.core.userdetails.User(loadedUser.getName(), loadedUser.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(loadedUser.getRole().getName())));
    }
}
