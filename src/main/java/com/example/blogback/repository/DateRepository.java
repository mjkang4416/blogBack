package com.example.blogback.repository;

import com.example.blogback.entity.DateEntity;
import com.example.blogback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

public interface DateRepository extends JpaRepository<DateEntity, Long> {
    @Query("SELECT SUM(d.timeRecorded), DATE(d.createDate) AS day " +
            "FROM DateEntity d " +
            "WHERE d.userId = :userId " +
            "GROUP BY DATE(d.createDate) " +
            "ORDER BY DATE(d.createDate) ASC")
    List<Object[]> getSumDateRecord(@AuthenticationPrincipal UserEntity userId);
}
