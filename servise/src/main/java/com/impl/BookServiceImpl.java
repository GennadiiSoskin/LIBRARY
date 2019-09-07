package com.impl;

import com.api.BookService;
import com.entity.Book;
import com.entity.Library;
import com.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    public void add(Book book) {

    }

    @Override
    public List<Book> show(Library library) {
        return repository.getAll();
    }

    public void delete(Long id) {

    }
}
