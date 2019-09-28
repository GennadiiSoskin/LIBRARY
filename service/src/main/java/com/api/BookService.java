package com.api;


import com.entity.Book;
import com.entity.Genre;
import com.entity.Library;
import com.entity.User;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;


public interface BookService {

    void takeBookById(Long id, User user);

    void returnBookById(Long id);

    List<Book> findByUser (User user);

    Page<Book> findByParameters(String name, Long genre, Long library ,int pageIndex, int pageSize);

    Optional<Book> findById(Long id);

    Optional<Genre> findGenreByBookId(Long id);

    Optional<Library> findLibraryByBookId(Long id);

    String bookState (Long id);

}
