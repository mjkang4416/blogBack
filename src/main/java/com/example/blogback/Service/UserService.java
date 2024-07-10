package com.example.blogback.Service;


import com.example.blogback.dto.accounts.MyPageDTO;
import com.example.blogback.dto.accounts.UserDTO;
import com.example.blogback.entity.BookLogEntity;
import com.example.blogback.entity.UserEntity;
import com.example.blogback.repository.BookLogRepository;
import com.example.blogback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final BookLogRepository bookLogRepository;
    private final BookLogService bookLogService;

    public UserEntity getUserByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    public UserEntity createUser(UserDTO userDTO) {

        UserEntity userEntity = UserEntity.builder()
                .nickname(userDTO.getNickname())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .email(userDTO.getEmail())
                .img_url(userDTO.getImg_url())
                .intro(userDTO.getIntro())
                .build();
        return userRepository.save(userEntity);
    }
    
    public MyPageDTO getMyPage(@AuthenticationPrincipal UserEntity userEntity) {
        Long userId =userEntity.getUserId();
        UserEntity user = getUserByUserId(userId);

        List<BookLogEntity> bookLogEntities;
        bookLogEntities = bookLogService.getBookLog(userId);


        return MyPageDTO.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .img_url(user.getImg_url())
                .intro(user.getIntro())
                .bookLogs(bookLogEntities)
                .build();
    }



    public UserEntity getUserByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }
}