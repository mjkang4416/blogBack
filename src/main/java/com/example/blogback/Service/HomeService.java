package com.example.blogback.Service;

import com.example.blogback.entity.UserEntity;
import com.example.blogback.repository.DateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {
    private final DateRepository dateRepository;

    // 로그인한 사용자의 하루 기록 시간 보여줌
    public List<Object[]> DayRecord(@AuthenticationPrincipal UserEntity userEntity){
        List<Object[]> dateList = dateRepository.getSumDateRecord(userEntity);
        return dateList;
    }
}
