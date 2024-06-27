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
    @JoinColumn(name = "USERID", nullable = false)
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "USERID", nullable = false)
    private UserEntity friends;

}
