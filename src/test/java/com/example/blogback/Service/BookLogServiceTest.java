package com.example.blogback.Service;

import com.example.blogback.dto.blog.BookLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class BookLogServiceTest {


    @Autowired
    BookLogService bookLogService;

    Date now = new Date();

    BookLogDTO bookLogDTO = BookLogDTO.builder().bookLogId(1L)
            .content("adsfsd")
            .title("alskjf")
            .update_date(now)
            .write_date(now)
            .userId(1L)
            .bookId(1L)
            .build();

    @Test
    public void bookLogInsertTest(BookLogDTO bookLogDTO){
        bookLogService.BookLogPost(bookLogDTO);

    }

}