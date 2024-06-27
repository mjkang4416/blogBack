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
public class  CreateDate {
    @Id
    @Column(name = "dateid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dateid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creat_date;

    @Column(name = "time_recorded", nullable = false)
    private Long time_recorded;

    @ManyToOne
    @JoinColumn(name ="userId",nullable = false)
    private tbl_user userId;

}