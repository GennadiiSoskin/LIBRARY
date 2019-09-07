package com.repository.impl;

import com.entity.Book;
import com.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List getAll() {
        String name = "Маленький принц";
        return sessionFactory.getCurrentSession()
                .createQuery("select b from " + Book.class.getSimpleName() + " b where b.name = :name", Book.class)
                .list();
    }

    @Override
    public void saveBook(Book book) {
//    TODO
    }

    @Override
    public void updateBook(Book book) {
//    TODO
    }

    @Override
    public void deleteBook(Long id) {
//    TODO
    }


}
