package com.example.blogback.Service;

import com.example.blogback.dto.accounts.UserDTO;
import com.example.blogback.dto.blog.BookLogDTO;
import com.example.blogback.entity.BookEntity;
import com.example.blogback.entity.BookLogEntity;
import com.example.blogback.entity.UserEntity;
import com.example.blogback.repository.BookLogRepository;
import com.example.blogback.repository.BookRepository;
import com.example.blogback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLogService {

    private final BookLogRepository bookLogRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    //  전체 booklog 띄워주는 화면
    public List<BookLogEntity> getBookLog(Long userId){
        return bookLogRepository.findByUserId(UserEntity.builder().userId(userId).build());
    }


    //    bookLog post
    public void BookLogPost(BookLogDTO bookLogDTO){
        BookLogEntity bookLogEntity = BookLogEntity.builder()
                .content(bookLogDTO.getContent())
                .title(bookLogDTO.getTitle())
                .updateDate(bookLogDTO.getUpdate_date())
                .writeDate(bookLogDTO.getUpdate_date())
                .userId(userRepository.findByUserId(bookLogDTO.getUserId()))
                .bookId(bookRepository.findByBookId(bookLogDTO.getBookId()))
                .build();

        bookLogRepository.save(bookLogEntity);
    }

//    책검색
    public List<BookEntity> SearchBook(String bookName){
       return bookRepository.findByTitleStartingWith(bookName);
    }

//    북로그 삭제
    public void deleteBookLog(Long bookLogId){
      BookLogEntity bookLogEntityId =  BookLogEntity.builder().bLogId(bookLogId).build();
      bookLogRepository.delete(bookLogEntityId);
    }



}
