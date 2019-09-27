package com.api;


import com.entity.Book;
import com.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;


public interface BookService {

    void takeBookById(Long id, User user);

    void comeBackBookById(Long id);

    List<Book> findByUser (User user);

    Page<Book> findByParameters(String name, Long genre, Long library ,int pageIndex, int pageSize);
}
