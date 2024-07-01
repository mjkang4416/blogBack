package com.example.blogback.repository;

import com.example.blogback.entity.BookEntity;
import com.example.blogback.entity.BookLogEntity;
import com.example.blogback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookLogRepository extends JpaRepository<BookLogEntity, Long>{
   List<BookLogEntity>findByUserId(UserEntity userId);
}