package com.example.blogback.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_DATE")
public class DateEntity {
    @Id
    @Column(name = "date_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long date_id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creat_date;

    @Column(name = "time_Recorded", nullable = false)
    private Long time_recorded;

    @ManyToOne
    @JoinColumn(name ="user_id",nullable = false)
    private UserEntity userId;

}