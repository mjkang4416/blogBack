package com.example.blogback.Service;

import com.example.blogback.dto.timer.TimerDTO;
import com.example.blogback.entity.TimerEntity;
import com.example.blogback.repository.TimerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimerService {
    private final TimerRepository timerRepository;

    public TimerEntity recordTime(TimerDTO timerDTO) {
        TimerEntity timerEntity =TimerEntity.builder()
                .record_time(timerDTO.getRecord_time())
                .book_mark(timerDTO.getBook_mark())
               /* .book_id(timerDTO.getBook_id())
                .user_id(timerDTO.getUser_id())*/
                .build();
        return timerRepository.save(timerEntity);
    }
}
