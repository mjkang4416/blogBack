package com.example.blogback.controller.timer;


import com.example.blogback.Service.TimerService;
import com.example.blogback.dto.timer.DateDTO;
import com.example.blogback.dto.timer.RecordingDTO;
import com.example.blogback.dto.timer.TimerDTO;
import com.example.blogback.entity.DateEntity;
import com.example.blogback.entity.TimerEntity;
import com.example.blogback.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/timer")
@RequiredArgsConstructor
public class TimerController {
    private final TimerService timerService;
    // 기록된 시간 보여줌
    @GetMapping("/recorded")
    public List<TimerEntity> recordedTime(@AuthenticationPrincipal UserEntity userEntity) {
        return timerService.getRecordedTime(userEntity);
    }

    // 프론트에서 넘겨받은 시간 저장
    @PostMapping("/recording")
    public RecordingDTO saveTimeAndDate(@AuthenticationPrincipal UserEntity userEntity, @RequestBody RecordingDTO recordingDTO) {
        CompletableFuture<TimerEntity> recordTime = timerService.recordTimeAsync(userEntity, recordingDTO.getTimerDTO());
        CompletableFuture<DateEntity> recordDate = timerService.recordDateAsync(userEntity, recordingDTO.getDateDTO());
        CompletableFuture.allOf(recordTime, recordDate).join();
        return recordingDTO;
    }
}
