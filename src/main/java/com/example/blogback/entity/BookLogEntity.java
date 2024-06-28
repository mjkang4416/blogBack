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

        private Long b_log_id;

        private String title;

        private String content;

        private Long score;

        @Temporal(TemporalType.TIMESTAMP)
        private Date write_date;

        @Temporal(TemporalType.TIMESTAMP)
        private Date update_date;


        @ManyToOne
        @JoinColumn(name = "book_id",nullable = false)
        private BookEntity book_id;

        @ManyToOne
        @JoinColumn(name = "user_id",nullable = false)
        private UserEntity user_id;

}