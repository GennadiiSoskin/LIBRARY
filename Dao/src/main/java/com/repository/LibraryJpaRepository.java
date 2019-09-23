package com.repository;

import com.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryJpaRepository extends JpaRepository<Library,Long> {
    @Override
    Optional<Library> findById(Long aLong);
}
