package com.example.blogback.repository;

import com.example.blogback.entity.FriendsEntity;
import com.example.blogback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsRepository extends JpaRepository<FriendsEntity, Long> {
    List<FriendsEntity> findByUserId(UserEntity userId);
}
