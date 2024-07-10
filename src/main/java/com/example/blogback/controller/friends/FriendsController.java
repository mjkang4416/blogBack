package com.example.blogback.controller.friends;

import com.example.blogback.Service.FriendsService;
import com.example.blogback.dto.friends.FriendPageDTO;
import com.example.blogback.entity.FriendsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friends")
@RequiredArgsConstructor
public class FriendsController {
    private final FriendsService friendsService;

    @PostMapping("/add")
    public FriendsEntity addFriend(@RequestParam String userNickname, @RequestParam String friendNickname) {

        return friendsService.addFriend(userNickname, friendNickname);
    }
    @GetMapping("/page")
    public FriendPageDTO getFriendPage(@RequestParam Long userId) {
        return friendsService.getFriendPage(userId);
    }
}
