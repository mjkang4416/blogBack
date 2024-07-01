package com.example.blogback.controller.timer;


import com.example.blogback.Service.TimerService;
import com.example.blogback.dto.timer.DateDTO;
import com.example.blogback.dto.timer.RecordingDTO;
import com.example.blogback.dto.timer.TimerDTO;
import com.example.blogback.entity.DateEntity;
import com.example.blogback.entity.TimerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/timer")
@RequiredArgsConstructor
public class TimerController {
    private final TimerService timerService;
    // 기록된 시간 보여줌

    // 프론트에서 넘겨받은 시간 저장
    @PostMapping("/recording")
    public void saveTimeAndDate(@RequestBody RecordingDTO recordingDTO) {
        CompletableFuture<TimerEntity> recordTime = timerService.recordTimeAsync(recordingDTO.getTimerDTO());
        CompletableFuture<DateEntity> recordDate = timerService.recordDateAsync(recordingDTO.getDateDTO());
        CompletableFuture.allOf(recordTime, recordDate).join();

    }
}
