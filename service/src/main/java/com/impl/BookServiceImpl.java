package com.impl;

import com.api.BookService;
import com.entity.Book;
import com.entity.Library;
import com.entity.User;
import com.repository.BookJpaRepository;
import com.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookJpaRepository jpaRepository;

    public void add(Book book) {

    }


    @Override
    public void takeBookById(Long id, User user) {
        Book book = jpaRepository.findById(id).get();
        book.setUser(user);
                repository.update(book);
    }

    @Override
    public void comeBackBookById(Long id) {
        System.out.println("EUEUEUEUEU");
        Book book = jpaRepository.findById(id).get();
        System.out.println(book);
        book.setUser(null);
        System.out.println(book);
        repository.update(book);
    }

    @Override
    public List<Book> findByUser(User user) {
        System.out.println(jpaRepository.findAllByUser(user).toString());
        return jpaRepository.findAllByUser(user);
    }

    @Override
    public Page<Book> findByParameters(String name, Long genre, Long library, int pageIndex, int pageSize) {
        Page<Book> books;

        if (name != null) {
            books = jpaRepository.findAllByNameContaining(name, PageRequest.of(pageIndex, pageSize));
        } else {
//
                books = jpaRepository.findAll(PageRequest.of(pageIndex, pageSize));

            }


        return books;
    }
}
