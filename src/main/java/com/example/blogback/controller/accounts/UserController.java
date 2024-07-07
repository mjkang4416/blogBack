package com.example.blogback.controller.accounts;


import com.example.blogback.Service.UserService;
import com.example.blogback.dto.accounts.MyPageDTO;
import com.example.blogback.dto.accounts.UserDTO;
import com.example.blogback.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor//여기서 생성자 의존성 주입 되는거에여 안되는거 아님 @Autuwired는 없지만 final로 선언돼서 생성자에서 초기화되면서 자동 주입함
public class UserController {
    public final UserService userService;

    //유저 정보 조회할라면 유저가 필요해서 그거 만드는 용이에여 임시일 뿐
    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }
    @GetMapping("/mypage")
    public MyPageDTO getUserMypage(@RequestParam Long userId) {
        return userService.getMyPage(userId);
    }
    //로그인
    @PostMapping("/login")
    public UserEntity login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }





}

