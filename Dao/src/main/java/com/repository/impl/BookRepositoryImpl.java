package com.repository.impl;

import com.entity.Book;
import com.entity.Genre;
import com.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List<Book> getAll() {
        String name = "Маленький принц";
         List list = sessionFactory.getCurrentSession()
                .createQuery("from " + Book.class.getSimpleName() , Book.class)
                .list();
        System.out.print(list.toString());
         return list;
    }
//TODO genrerepositoryimpl
@Override
public List<Genre> getAllBookByGenre(long id) {
    String name = "Маленький принц";
    List list = sessionFactory.getCurrentSession()
            .createQuery("from " + Genre.class.getSimpleName() + " g where g.id = 1", Genre.class)
            .list();
    System.out.print(list.toString());
    return list;

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
