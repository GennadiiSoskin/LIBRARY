package com.api;


import com.entity.Book;
import com.entity.Library;
import org.springframework.data.domain.Page;
import java.util.List;

public interface BookService {
    void add(Book book);

    List<Book> show(Library library);

    void delete(Long id);

    Page<Book> findByParameters(String name, Long genre, Long library ,int pageIndex, int pageSize);
}
