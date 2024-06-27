package com.example.blogback.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_LIKE")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @Column(name = "LIKE", nullable = false)
    private Boolean like;

    @ManyToOne
    @JoinColumn(name = "USERID", nullable = false)
    private UserEntity userId;

}
