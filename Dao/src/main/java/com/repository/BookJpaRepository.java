package com.repository;

import com.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.validation.constraints.NotEmpty;
import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
    @Override
    Page<Book> findAll(Pageable pageable);

    @Override
    Optional<Book> findById(Long id);


    Page<Book> findAllByNameContaining(@NotEmpty String name, Pageable pageable);

//    Page<Book> findAllByGenreAndLibrary(@NotEmpty long genre, @NotEmpty long library, Pageable pageable);

//    Page<Book> findAllByGenre(@NotEmpty Long genre, Pageable pageable);
//
//    Page<Book> findAllByLibrary(@NotEmpty Long library, Pageable pageable);
//
//
//    Page<Book> findAllByGenreAndLibrary(@NotEmpty Long genre, @NotEmpty Long library, Pageable pageable);

}