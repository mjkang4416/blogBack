package com.example.blogback.dto.friends;

import com.example.blogback.dto.blog.BookLogDTO;
import com.example.blogback.entity.BookLogEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FriendPageDTO {
    private Long userId;
    private String nickname;
    private String email;
    private String img_url;
    private String intro;
    private List<BookLogEntity> bookLogs; // BookLogs 포함
}
