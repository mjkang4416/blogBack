package com.example.blogback.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_TIMER")
public class Timer {
    @Id
    @Column(name = "timerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timerId;

    @Column(name = "record_time", nullable = false)
    private Long record_time;

    @Column(name = "book_mark", nullable = false)
    private Long book_mark;

    @ManyToOne
    @JoinColumn(name ="bookId",nullable = false)
    private tbl_book bookId;

    @ManyToOne
    @JoinColumn(name ="userId",nullable = false)
    private tbl_user userId;

}
