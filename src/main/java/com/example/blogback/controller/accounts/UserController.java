package com.example.blogback.controller.accounts;


import com.example.blogback.Service.UserService;
import com.example.blogback.dto.accounts.UserDTO;
import com.example.blogback.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor//여기서 생성자 의존성 주입 되는거에여 안되는거 아님 @Autuwired는 없지만 final로 선언돼서 생성자에서 초기화되면서 자동 주입함
public class UserController {
    public final UserService userService;

    @GetMapping("/mypage/{nickname}")
    public UserEntity getUserMypage(@PathVariable String nickname) {
        // 닉네임으로 사용자 정보를 조회하는거ㅣㅁ
        return userService.getUserByNickname(nickname);
    }
    //유저 정보 조회할라면 유저가 필요해서 그거 만드는 용이에여 임시일 뿐
    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }
}
