package com.example.blogback.repository;

import com.example.blogback.entity.BookLogEntity;
import com.example.blogback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLogRepository extends JpaRepository<BookLogEntity, Long>{

}