package com.controller;

import com.api.BookService;
import com.api.UserService;
import com.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final HttpSession session;
    private final BookService bookService;
    private final UserService userService;

    @GetMapping("/admin-page")
    public String adminPage(Model model) {

        User user = (User) session.getAttribute("loginedUser");//TEST
        if (user == null) {
            return "login-page";
        }
        if (!user.getRole().getName().equals("admin")) {
            return "user-page";
        }
        model.addAttribute("userName", user.getName());
        return "admin-page";
    }

    @GetMapping("/users")

    public String seekUsers(@RequestParam(value = "page", required = false, defaultValue = "0") int pageIndex,
                            Model model) {
        Page<User> all = userService.findAll(pageIndex);
        int totalPagesCount = all.getTotalPages();
        model.addAttribute("users", all.getContent());
        model.addAttribute("totalPagesCount", totalPagesCount);

        return "users";
    }


    @GetMapping("/user")
    //TODO check passwords
    public String user(@RequestParam(value = "userName") String userName, Model model) {
        Optional<User> optionalUser = userService.findByName(userName);

        model.addAttribute("user", optionalUser.get());
        model.addAttribute("bookList", bookService.findByUser(optionalUser.get()));
        return "user";
    }

    @GetMapping("/replace")
    //TODO check passwords
    public String comeBack(@RequestParam(value = "userName") String userName,
                           @RequestParam(value = "bookId") Long bookId,
                           Model model) {
        bookService.returnBookById(bookId);
        Optional<User> optionalUser = userService.findByName(userName);
        model.addAttribute("userName", optionalUser.get().getName());
        model.addAttribute("bookList", bookService.findByUser(optionalUser.get()));
        return "redirect:user";
    }
}
