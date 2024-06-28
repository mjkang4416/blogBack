package com.example.blogback.Service;

import com.example.blogback.dto.accounts.UserDTO;
import com.example.blogback.entity.UserEntity;
import com.example.blogback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity getUserByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    public UserEntity createUser(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.builder()
                .nickname(userDTO.getNickname())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .img_url(userDTO.getImgUrl())
                .intro(userDTO.getIntro())
                .build();
        return userRepository.save(userEntity);
    }

}