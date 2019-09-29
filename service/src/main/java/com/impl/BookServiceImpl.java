package com.impl;

import com.api.BookService;
import com.entity.Book;
import com.entity.Genre;
import com.entity.Library;
import com.entity.User;
import com.repository.BookJpaRepository;
import com.repository.BookRepository;
import com.repository.GenreJpaRepository;
import com.repository.LibraryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookJpaRepository jpaRepository;
    private final GenreJpaRepository genreJpaRepository;
    private final LibraryJpaRepository libraryJpaRepository;


    @Override
    public void takeBookById(Long id, User user) {
        Book book = jpaRepository.findById(id).get();
        book.setUser(user);
        repository.update(book);
    }

    @Override
    public void returnBookById(Long id) {
        Book book = jpaRepository.findById(id).get();
        book.setUser(null);
        repository.update(book);
    }

    @Override
    public List<Book> findByUser(User user) {
        System.out.println(jpaRepository.findAllByUser(user).toString());
        return jpaRepository.findAllByUser(user);
    }

    @Override
    public Page<Book> findByParameters(String name, int pageIndex, int pageSize) {
        Page<Book> books;
        if (name != null) {
            books = jpaRepository.findAllByNameContaining(name, PageRequest.of(pageIndex, pageSize));
        } else {
            books = jpaRepository.findAll(PageRequest.of(pageIndex, pageSize));
        }
        return books;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Optional<Genre> findGenreByBookId(Long id) {
        return genreJpaRepository.findById(findById(id).orElse(new Book()).getGenre());
    }

    @Override
    public Optional<Library> findLibraryByBookId(Long id) {
        return libraryJpaRepository.findById(findById(id).orElse(new Book()).getLibrary());
    }

    @Override
    public String bookState(Long id) {
        Book book = findById(id).orElse(new Book());
        if (book.getUser() == null) {
            return "Заказать";
        }
        return null;
    }
}
