package com.api;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserService {
    public UserDetails loadUserByUsername(String login);
}
