package com.example.blogback.dto.accounts;


import com.example.blogback.dto.blog.BookLogDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
    private Long userId;
    private String nickname;
    private String password;
    private String email;
    private String img_url;
    private String intro;
    private List<BookLogDTO> bookLogs;

}