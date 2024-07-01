package com.example.blogback.repository;

import com.example.blogback.entity.DateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<DateEntity, Long> {
}
