package com.example.blogback.Service;

import com.example.blogback.dto.accounts.UserDTO;
import com.example.blogback.entity.UserEntity;
import com.example.blogback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

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
    public UserEntity login(UserDTO userDTO) {

        UserEntity userEntity = userRepository.findByUserId(userDTO.getUserId());

        if (userEntity != null && passwordEncoder.matches(userDTO.getPassword(), userEntity.getPassword())) {
            return userEntity;
        }

        return null;

    }


    public UserEntity getUserByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }
}