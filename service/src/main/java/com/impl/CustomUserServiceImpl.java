package com.impl;


import com.api.CustomUserService;
import com.entity.User;
import com.repository.UserJpaRepository;
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
public class CustomUserServiceImpl  implements CustomUserService {
    private final UserJpaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User loadedUser = repository.findUserByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find user by provided name!"));

        return new org.springframework.security.core.userdetails.User(loadedUser.getName(), loadedUser.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(loadedUser.getRole().getName())));
    }
}
