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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dateId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(nullable = false)
    private Long timeRecorded;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserEntity userId;

}