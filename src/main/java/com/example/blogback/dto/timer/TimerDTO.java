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
    private Long timer_id;
    private Long record_time;
    private Long book_mark;
    private Long book_id;
    private Long user_id;
}
