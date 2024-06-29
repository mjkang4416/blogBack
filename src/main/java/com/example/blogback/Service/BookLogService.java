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

@Service
@RequiredArgsConstructor
public class BookLogService {

    private final BookLogRepository bookLogRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public void BookLogUpdate(BookLogDTO bookLogDTO){
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
}
