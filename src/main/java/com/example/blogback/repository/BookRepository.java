package com.example.blogback.repository;

import com.example.blogback.entity.BookEntity;
import com.example.blogback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findByTitle(String Title);
    List<BookEntity> findByTitleStartingWith(String title);

    BookEntity findByBookId(Long bookId);
}
