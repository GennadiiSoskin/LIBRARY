package com.repository.impl;

import com.entity.Book;
import com.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Override
    public void save(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public void update(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }
}
