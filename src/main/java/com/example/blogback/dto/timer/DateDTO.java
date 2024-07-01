package com.example.blogback.dto.timer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DateDTO {
    private Long dateId;
    private Date createDate;
    private Long timeRecorded;
    private Long userId;
}
