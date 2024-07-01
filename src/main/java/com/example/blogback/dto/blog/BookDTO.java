package com.example.blogback.dto.blog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BookDTO {
    private Long bookId;
    private String title;
    private String author;
    private String bookCover;
}
