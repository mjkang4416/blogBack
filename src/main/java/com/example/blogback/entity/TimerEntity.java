package com.example.blogback.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_TIMER")
public class TimerEntity {
    @Id
    @Column(name = "timer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timer_id;

    @Column(name = "record_time", nullable = false)
    private Long record_time;

    @Column(name = "book_mark", nullable = false)
    private Long book_mark;

    @ManyToOne
    @JoinColumn(name ="book_id",nullable = false)
    private BookEntity book_id;

    @ManyToOne
    @JoinColumn(name ="user_id",nullable = false)
    private UserEntity user_id;

}
