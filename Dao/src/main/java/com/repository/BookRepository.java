package com.repository;

import com.entity.Book;



public interface BookRepository {

    void save (Book book);
    void update(Book book);

}
