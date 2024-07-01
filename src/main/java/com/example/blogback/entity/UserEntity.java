package com.example.blogback.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TBL_USER")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String nickname;
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String img_url;
    private String intro;

    @OneToMany(mappedBy = "userId")
    private List<LikeEntity> likes;

}
