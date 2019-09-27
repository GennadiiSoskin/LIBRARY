package com.repository;

import com.entity.Book;
import com.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
    @Override
    Page<Book> findAll(Pageable pageable);

    @Override
    Optional<Book> findById(Long id);

    Page<Book> findAllByNameContaining(@NotEmpty String name, Pageable pageable);


    List<Book> findAllByUser(User user);
}