package com.example.blogback.repository;

import com.example.blogback.entity.TimerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimerRepository extends JpaRepository<TimerEntity, Long> {
}
