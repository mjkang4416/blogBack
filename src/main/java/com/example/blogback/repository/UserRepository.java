package com.example.blogback.repository;

import com.example.blogback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByNickname(String nickname);
    UserEntity findByUserId(Long userId);


}