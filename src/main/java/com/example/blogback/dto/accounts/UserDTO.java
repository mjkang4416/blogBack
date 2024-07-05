package com.example.blogback.dto.accounts;


import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
    private Long userId;
    private String nickname;
    private String password;
    private String email;
    private String img_url;
    private String intro;



}