package com.controller;

import com.api.BookService;
import com.entity.Book;
import com.entity.Genre;
import com.entity.Library;
import com.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final HttpSession session;
    private final BookService bookService;

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

    public String seek(@RequestParam(value = "bookId") Long bookId, Model model) {

        model.addAttribute("book", bookService.findById(bookId).orElse(new Book()));
        model.addAttribute("genre", bookService.findGenreByBookId(bookId).orElse(new Genre()));
        model.addAttribute("library", bookService.findLibraryByBookId(bookId).orElse(new Library()));
        model.addAttribute("message", bookService.bookState(bookId));
        return "book";
    }

    @PostMapping("/book")
    public String takeBook(Long bookId, Model model) {
        User user = (User) session.getAttribute("loginedUser");
        bookService.takeBookById(bookId, user);
        return "redirect:" + user.getRole().getName() + "-page";
    }
}