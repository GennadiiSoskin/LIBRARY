package com.controller;


import com.api.BookService;
import com.api.CustomUserService;
import com.entity.*;
import com.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final BookService bookService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    //    private final PasswordEncoder passwordEncoder;
    private final BookRepository bookRepository;
    private final BookJpaRepository bookJpaRepository;
    private final GenreJpaRepository genreJpaRepository;
    private final LibraryJpaRepository libraryJpaRepository;

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
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(userRole);
        System.out.println(user.toString());
//        bookRepository.saveUser(user);
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

    @GetMapping("/users-pagination")
    //TODO check passwords
    public String seek(@RequestParam(value = "page", required = false, defaultValue = "0") int pageIndex,
                       @RequestParam("size") int pageSize,
                       @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "genre", required = false) Long genre,
                       @RequestParam(value = "library", required = false) Long library,
                       Model model) {
        Page<Book> all = bookService.findByParameters(name, genre, library, pageIndex, pageSize);
        int totalPagesCount = all.getTotalPages();
        model.addAttribute("books", all.getContent());
        model.addAttribute("totalPagesCount", totalPagesCount);
        model.addAttribute("itemsPerPage", pageSize);
        model.addAttribute("genre", genre);
        model.addAttribute("library", library);
        model.addAttribute("name", name);
        return "users-pagination";
    }

    @GetMapping("/book")
    //TODO check passwords
    public String seek(@RequestParam(value = "bookId") Long bookId, Model model) {
        Optional<Book> book = bookJpaRepository.findById(bookId);
        Book loadedBook = book.get();
        Optional<Genre> genre = genreJpaRepository.findById(loadedBook.getGenre());
        Optional<Library> library = libraryJpaRepository.findById(loadedBook.getLibrary());
        model.addAttribute("book", book.get());
        model.addAttribute("genre", genre.get());
        model.addAttribute("library", library.get());

        return "book";
    }

}


