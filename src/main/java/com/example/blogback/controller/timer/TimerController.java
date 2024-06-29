package com.example.blogback.controller.timer;


import com.example.blogback.Service.TimerService;
import com.example.blogback.dto.timer.TimerDTO;
import com.example.blogback.entity.TimerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timer")
@RequiredArgsConstructor
public class TimerController {
    public TimerService timerService;
    // 기록된 시간 보여줌

    // 프론트에서 넘겨받은 시간 저장
    @PostMapping("/recording")
    public TimerEntity recordTime(@RequestBody TimerDTO timerDTO){
        return timerService.recordTime(timerDTO);
    }
}
