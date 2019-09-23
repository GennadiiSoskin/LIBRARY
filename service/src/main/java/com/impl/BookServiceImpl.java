package com.impl;

import com.api.BookService;
import com.entity.Book;
import com.entity.Library;
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
    public List<Book> show(Library library) {
        return repository.getAll();
    }

    public void delete(Long id) {

    }

    @Override
    public Page<Book> findByParameters(String name, Long genre, Long library, int pageIndex, int pageSize) {
        Page<Book> books;

        if (name != null) {
            books = jpaRepository.findAllByNameContaining(name, PageRequest.of(pageIndex, pageSize));
        } else {
//            if (library != null) {
//                if (genre != null) {
//                    books = jpaRepository.findAllByGenreAndLibrary(genre, library, PageRequest.of(pageIndex, pageSize));
//                } else {
//                    books = jpaRepository.findAllByLibrary(library, PageRequest.of(pageIndex, pageSize));
//                }return books;
//            } else {
//                if (genre != null) {
//                    books = jpaRepository.findAllByGenre(genre, PageRequest.of(pageIndex, pageSize));
//                    return books;
//                }
                books = jpaRepository.findAll(PageRequest.of(pageIndex, pageSize));

            }


        return books;
    }
}
