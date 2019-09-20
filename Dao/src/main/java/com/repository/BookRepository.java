package com.repository;

import com.entity.Book;
import com.entity.User;


import java.util.List;

public interface BookRepository {
    void saveBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);

    List<Book> getAll();

   void getAllBookByGenre(long id);

   void saveUser(User user);
}
