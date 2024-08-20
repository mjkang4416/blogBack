package com.example.blogback.repository;

import com.example.blogback.entity.BookEntity;
import com.example.blogback.entity.TimerEntity;
import com.example.blogback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TimerRepository extends JpaRepository<TimerEntity, Long> {
    Optional<TimerEntity> findByUserIdAndBookId(UserEntity userId, BookEntity bookId);
    List<TimerEntity> findByUserId(UserEntity userId);
}

