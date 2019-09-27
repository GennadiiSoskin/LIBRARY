package com.controller;


import com.api.BookService;
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

    private final BookService bookService;
    private final RoleRepository roleRepository;
    private final UserJpaRepository userJpaRepository;
    //    private final PasswordEncoder passwordEncoder;
    private final BookRepository bookRepository;
    private final BookJpaRepository bookJpaRepository;
    private final GenreJpaRepository genreJpaRepository;
    private final LibraryJpaRepository libraryJpaRepository;
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
        Role userRole = roleRepository.findByName("USER");
//     TODO          user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(userRole);
        if (userService.save(user)) {
            return "redirect:login-page";
        } else {
            model.addAttribute("mistake", "Такой пользователь уже зарегистрирован");
            return "redirect:registration-page";
        }
    }

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

    @GetMapping("/user-page")
    public String userPage(Model model) {
        User user = (User) session.getAttribute("loginedUser");
        if (user == null) {
            return "login-page";
        }

        model.addAttribute("userName", user.getName());
        model.addAttribute("bookList", bookService.findByUser(user));
        return "user-page";
    }

    @GetMapping("/books")
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
        return "books";
    }

    @GetMapping("/book")
    //TODO check passwords
    public String seek(@RequestParam(value = "bookId") Long bookId, Model model) {

        String message = null;
        Optional<Book> book = bookJpaRepository.findById(bookId);
        Book loadedBook = book.get();
        User user = book.get().getUser();
        Optional<Genre> genre = genreJpaRepository.findById(loadedBook.getGenre());
        Optional<Library> library = libraryJpaRepository.findById(loadedBook.getLibrary());
        model.addAttribute("book", book.get());
        model.addAttribute("genre", genre.get());
        model.addAttribute("library", library.get());
        if (user != null) {
        } else {
            message = " Заказать ";
        }
        model.addAttribute("message", message);
        return "book";
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

    @PostMapping("/book")
    public String takeBook(Long bookId, Model model) {
        User user = (User) session.getAttribute("loginedUser");
        bookService.takeBookById(bookId, user);
        return "redirect:" + user.getRole().getName() + "-page";
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
        bookService.comeBackBookById(bookId);
        Optional<User> optionalUser = userService.findByName(userName);
        model.addAttribute("userName", optionalUser.get().getName());
        model.addAttribute("bookList", bookService.findByUser(optionalUser.get()));
        return "redirect:user";
    }

}


