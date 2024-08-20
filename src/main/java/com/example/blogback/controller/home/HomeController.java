package com.example.blogback.controller.home;

import com.example.blogback.Service.HomeService;
import com.example.blogback.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @GetMapping("/dayRecord")
    public List<Object[]> dayRecord(@AuthenticationPrincipal UserEntity userEntity) {
        return homeService.DayRecord(userEntity);
    }
}
