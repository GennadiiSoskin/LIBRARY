package com.repository;

import com.entity.Book;

import java.util.Optional;


public interface BookRepository {

    void save (Book book);
    void update(Book book);
    Optional<Book> getBook(String name);

}
