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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timerId;

    @Column(nullable = false)
    private Long recordTime;

    @Column(nullable = false)
    private Long bookMark;

    @ManyToOne
    @JoinColumn(nullable = false)
    private BookEntity bookId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserEntity userId;

}
