package com.example.blogback.dto.accounts;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String nickname;
    private String password;
    private String email;
    private String imgUrl;
    private String intro;
}