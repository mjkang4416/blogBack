package com.example.blogback.dto.blog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookLogDTO {
    private Long bookLogId;
    private String content;
    private String title;
    private Date update_date;
    private Date write_date;
    private Long userId;
    private Long bookId;
}
