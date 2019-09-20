package com.controller;


import com.api.CustomUserService;
import com.entity.Role;
import com.entity.User;
import com.repository.BookRepository;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.OptionalDataException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PageController {

private final CustomUserService customUserService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BookRepository bookRepository;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/login-page")
    public String loginForm() {
        return "login-page";
    }

    @GetMapping("/registration-page")
    public String registrationForm() {
        return "registration-page";
    }

    @PostMapping("/registration-page")
    //TODO check passwords
    public String registration(@ModelAttribute("user") User user, String confirmPassword) {
        System.out.println(user.toString());
        Role userRole = roleRepository.findByName("USER");
        System.out.println(userRole.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(userRole);
        System.out.println(user.toString());
        bookRepository.saveUser(user);
        return "redirect:login-page";
    }

    @GetMapping("/admin-page")
    public String adminPage() {
        return "admin-page";
    }

    @GetMapping("/user-page")
    public String userPage() {
        return "user-page";
    }


}


