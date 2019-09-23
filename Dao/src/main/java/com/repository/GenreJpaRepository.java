package com.repository;

import com.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreJpaRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findById(Long id);
}
