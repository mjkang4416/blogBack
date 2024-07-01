package com.example.blogback.repository;

import com.example.blogback.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findByBookId(Long bookId);
}
