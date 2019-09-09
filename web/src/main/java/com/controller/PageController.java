package com.controller;


import com.entity.Role;
import com.entity.User;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/login-page")
    public String login() {
        return "login-page";
    }

    @GetMapping("/registration-page")
    public String registrationForm() {
        return "registration-page";
    }

    @PostMapping("/registration-page")
    //TODO check passwords
    public String registration(User user, String confirmPassword) {
        Role userRole = roleRepository.findByName("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(userRole);
        userRepository.save(user);
        return "redirect:login-page";
    }

    @GetMapping("/start-page")
    public String homePage() {
        return "start-page";
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


