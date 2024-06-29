package com.example.blogback.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_BOOK_LOG")
public class BookLogEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long bLogId;

        private String title;

        private String content;

        private Long score;

        @Temporal(TemporalType.TIMESTAMP)
        private Date writeDate;

        @Temporal(TemporalType.TIMESTAMP)
        private Date updateDate;


        @ManyToOne
        @JoinColumn(name = "book_id",nullable = false)
        private BookEntity bookId;

        @ManyToOne
        @JoinColumn(name = "user_id",nullable = false)
        private UserEntity userId;
}