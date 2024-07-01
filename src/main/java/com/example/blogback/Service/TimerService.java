package com.example.blogback.Service;

import com.example.blogback.dto.accounts.UserDTO;
import com.example.blogback.dto.blog.BookDTO;
import com.example.blogback.dto.timer.DateDTO;
import com.example.blogback.dto.timer.TimerDTO;
import com.example.blogback.entity.DateEntity;
import com.example.blogback.entity.UserEntity;
import com.example.blogback.entity.BookEntity;
import com.example.blogback.entity.TimerEntity;
import com.example.blogback.repository.DateRepository;
import com.example.blogback.repository.UserRepository;
import com.example.blogback.repository.BookRepository;
import com.example.blogback.repository.TimerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TimerService {
    private final TimerRepository timerRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final DateRepository dateRepository;


    @Async
    @Transactional
    public CompletableFuture<TimerEntity> recordTimeAsync(TimerDTO timerDTO){
        UserEntity userEntity = userRepository.findByUserId(timerDTO.getUserId());
        BookEntity bookEntity = bookRepository.findByBookId(timerDTO.getBookId());

            TimerEntity timerEntity =TimerEntity.builder()
                    .recordTime(timerDTO.getRecordTime())
                    .bookMark(timerDTO.getBookMark())
                    .bookId(bookEntity)
                    .userId(userEntity)
                    .build();
            TimerEntity saveTimerEntity = timerRepository.save(timerEntity);return CompletableFuture.completedFuture(saveTimerEntity);

    }
    @Async
    @Transactional
    public CompletableFuture<DateEntity> recordDateAsync(DateDTO dateDTO){
        UserEntity userEntity = userRepository.findByUserId(dateDTO.getUserId());
        DateEntity dateEntity = DateEntity.builder()
                .timeRecorded(dateDTO.getTimeRecorded())
                .createDate(dateDTO.getCreateDate())
                .userId(userEntity)
                .build();
        DateEntity savedDateEntity = dateRepository.save(dateEntity);
        return CompletableFuture.completedFuture(savedDateEntity);
    }

}