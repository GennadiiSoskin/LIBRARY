package com.repository.impl;

import com.entity.Book;
import com.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


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
    public Optional<Book> getBook(String name) {
        return sessionFactory.getCurrentSession()
                .createQuery("select e from " + Book.class.getSimpleName() + " e where e.name = :name", Book.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public void update(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }
}
