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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TimerService {
    private final TimerRepository timerRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final DateRepository dateRepository;



    // get 요청
    // 기록화면, 타이머 리스트 반환
    public List<TimerEntity> getRecordedTime(@AuthenticationPrincipal UserEntity userEntity) {

        return timerRepository.findByUserId(userEntity);
    }

    // post 요청
    @Async
    @Transactional
    public CompletableFuture<TimerEntity> recordTimeAsync(@AuthenticationPrincipal UserEntity userEntity, TimerDTO timerDTO) {
        // 로그인한 사용자 userId
        //Long userId = userEntity.getUserId();
        // 책 이름 검색해서 받아옴
        BookEntity bookEntity = bookRepository.findByBookId(timerDTO.getBookId());
        // 테이블에 사용자가 검색한 책을 읽은 기록이 있는지 확인
        Optional<TimerEntity> existingTimerEntity = timerRepository.findByUserIdAndBookId(userEntity, bookEntity);

        TimerEntity timerEntity;
        // 입력받은 유저id랑 책id가 이미 db에 있는 경우, 업데이트된 내용만 새로 저장, 나머지는 기존 값 가져옴
        if (existingTimerEntity.isPresent()) {
            TimerEntity existTimerEntity = existingTimerEntity.get();
            // 기존 레코딩된 시간에 더해서 저장됨
            Long totalRecordTime = timerDTO.getRecordTime() + existTimerEntity.getRecordTime();
            timerEntity = TimerEntity.builder()
                    .timerId(existTimerEntity.getTimerId())
                    .recordTime(totalRecordTime) // 프론트에서 보낸 값으로 저장하려면 timerDTO.getRecordTime()얘로 수정하기
                    .bookMark(timerDTO.getBookMark())
                    .userId(existTimerEntity.getUserId())
                    .bookId(existTimerEntity.getBookId())
                    .build();
        } else {// 새로운 데이터 입력 받는 경우
            timerEntity = TimerEntity.builder()
                    .recordTime(timerDTO.getRecordTime())
                    .bookMark(timerDTO.getBookMark())
                    .bookId(bookEntity)
                    .userId(userEntity)
                    .build();
        }
        TimerEntity saveTimerEntity = timerRepository.save(timerEntity);
        return CompletableFuture.completedFuture(saveTimerEntity);

    }

    @Async
    @Transactional
    public CompletableFuture<DateEntity> recordDateAsync(@AuthenticationPrincipal UserEntity userEntity, DateDTO dateDTO) {
        // 로그인한 사용자 userId

        DateEntity dateEntity = DateEntity.builder()
                .timeRecorded(dateDTO.getTimeRecorded())
                .createDate(dateDTO.getCreateDate())
                .userId(userEntity)
                .build();
        DateEntity savedDateEntity = dateRepository.save(dateEntity);
        return CompletableFuture.completedFuture(savedDateEntity);
    }
}

