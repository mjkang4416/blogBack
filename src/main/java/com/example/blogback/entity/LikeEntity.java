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
    private Long like_id;

    @Column(name = "is_liked", nullable = false)
    private Boolean is_liked;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userId;

}
