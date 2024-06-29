package com.example.blogback.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_FRIENDS")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FriendsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friendsId;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "friend_id", nullable = false)
    private UserEntity friends;

}
