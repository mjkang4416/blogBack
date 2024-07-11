package com.example.blogback.controller.friends;

import com.example.blogback.Service.FriendsService;
import com.example.blogback.Service.UserService;
import com.example.blogback.dto.friends.FriendPageDTO;
import com.example.blogback.entity.BookLogEntity;
import com.example.blogback.entity.FriendsEntity;
import com.example.blogback.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
@RequiredArgsConstructor
public class FriendsController {
    private final FriendsService friendsService;
    private final UserService userService;

    @PostMapping("/add")
    public FriendsEntity addFriend(@AuthenticationPrincipal UserEntity userEntity, @RequestParam String friendNickname) {

        return friendsService.addFriend(userEntity.getNickname(), friendNickname);
    }
    @GetMapping("/page")
    public FriendPageDTO getFriendPage(@RequestParam Long userId) {
        return friendsService.getFriendPage(userId);
    }
    @GetMapping("/bookLog")
    public List<BookLogEntity> getFriendBookLogs(@AuthenticationPrincipal UserEntity userId) {
        return friendsService.getFriendsBookLogs(userId);
    }
    @GetMapping("/search")
    public UserEntity getFriendByUserId(Long userId) {
        return userService.getUserByUserId(userId);
    }
}
