package com.api;


import com.entity.Book;
import com.entity.Library;

import java.util.List;

public interface BookService {
    void add(Book book);

    List<Book> show(Library library);

    void delete(Long id);
}
