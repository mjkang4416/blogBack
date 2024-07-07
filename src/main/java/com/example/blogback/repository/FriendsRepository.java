package com.example.blogback.repository;

import com.example.blogback.entity.FriendsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<FriendsEntity, Long> {
}
