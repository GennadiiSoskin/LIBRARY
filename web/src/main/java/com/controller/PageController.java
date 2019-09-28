package com.controller;


import com.api.BookService;
import com.api.RoleService;
import com.api.UserService;
import com.entity.*;
import com.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final RoleService roleService;
    private final UserService userService;
    private final HttpSession session;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/login-page")
    public String loginForm(@RequestParam(value = "mistake", required = false) String mistake,
                            Model model) {
        System.out.println(mistake);
        model.addAttribute("mistake", mistake);
        return "login-page";
    }

    @GetMapping("/registration-page")
    public String registrationForm(@RequestParam(value = "mistake", required = false) String mistake,
                                   Model model) {
        System.out.println(mistake);
        model.addAttribute("mistake", mistake);
        return "registration-page";
    }

    @PostMapping("/registration-page")
    public String registration(@ModelAttribute("user") User user, Model model) {
        Role userRole = roleService.findByName("USER");
        user.setRole(userRole);
        if (userService.save(user)) {
            return "redirect:login-page";
        } else {
            model.addAttribute("mistake", "Такой пользователь уже зарегистрирован");
            return "redirect:registration-page";
        }
    }

    @PostMapping("/login-page")
    public String login(String userName, String password, Model model) {
        Optional<User> user = userService.findByName(userName);
        if (user.isPresent()) {
            Role role = user.get().getRole();
            session.removeAttribute("loginedUser");
            session.setAttribute("loginedUser", user.get());
            return "redirect:" + role.getName() + "-page";
        } else {
            model.addAttribute("mistake", "Такой пользователь не зарегистрирован");
            return "redirect:login-page";
        }
    }
}


