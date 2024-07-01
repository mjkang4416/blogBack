package com.example.blogback.dto.timer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TimerDTO {
    private Long timerId;
    private Long recordTime;
    private Long bookMark;
    private Long bookId;
    private Long userId;
}
