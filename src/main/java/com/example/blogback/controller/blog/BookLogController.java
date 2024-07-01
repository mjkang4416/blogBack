package com.example.blogback.controller.blog;

import com.example.blogback.Service.BookLogService;
import com.example.blogback.dto.blog.BookLogDTO;
import com.example.blogback.entity.BookEntity;
import com.example.blogback.entity.BookLogEntity;
import com.example.blogback.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BookLogController {

    private final BookLogService bookLogService;

//  로그인된 사용자가 작성한 bookLog 검색
    @GetMapping("/MyBlog")
    public List<BookLogEntity> getBookLog(@RequestHeader(name ="userId") Long userId){
       return bookLogService.getBookLog(userId);
    }
//  책 첫이름따라 검색
    @GetMapping("/BookSearch")
    public List<BookEntity> getBooks(@RequestHeader(name = "title") String bookName){
       return bookLogService.SearchBook(bookName);
    }
//  bookLog post
    @PostMapping("/write")
    public void postBookLog(@RequestBody BookLogDTO bookLogDTO){
        bookLogService.BookLogPost(bookLogDTO);
    }

    @DeleteMapping("/delete/{bLogId}")
    public void deleteBookLog(@PathVariable Long bLogId) {
            bookLogService.deleteBookLog(bLogId);

    }
}
