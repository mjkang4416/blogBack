package com.example.blogback.repository;

import com.example.blogback.entity.BookEntity;
import com.example.blogback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findByTitle(String Title);
    BookEntity findByBookId(Long bookId);
}
