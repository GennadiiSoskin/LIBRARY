package com.repository.impl;

import com.entity.Book;
import com.entity.Genre;
import com.entity.Library;
import com.entity.User;
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
                .createQuery("from " + Library.class.getSimpleName() , Library.class)
                .list();
        System.out.print(list.toString());
         return list;
    }
//TODO genrerepositoryimpl
@Override
public void getAllBookByGenre(long id) {
    String name = "Маленький принц";
    List<Library> list = sessionFactory.getCurrentSession()
            .createQuery("from " + Library.class.getSimpleName(), Library.class)
            .list();
    Library genre = list.get(1);
    List<Book> books = genre.getBookList();
    System.out.println(books.toString());
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession()
                .save(user);
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
