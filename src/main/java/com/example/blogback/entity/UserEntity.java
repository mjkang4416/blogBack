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
    private Long user_id;

    @Column(nullable = false)
    private String nickname;
    private String password;
    private String email;

    @Column
    private String img_url;
    private String intro;

    @OneToMany(mappedBy = "user_id")
    private List<LikeEntity> likes;

}
