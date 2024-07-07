package com.example.blogback.Service;

import com.example.blogback.entity.FriendsEntity;
import com.example.blogback.entity.UserEntity;
import com.example.blogback.repository.FriendsRepository;
import com.example.blogback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendsService {
    private final FriendsRepository friendsRepository;
    private final UserRepository userRepository;

    public FriendsEntity addFriend(String userNickname, String friendNickname) {
        UserEntity user = userRepository.findByNickname(userNickname);
        System.out.print(user);
        UserEntity friend = userRepository.findByNickname(friendNickname);
        System.out.print(friend);

        FriendsEntity friendsEntity = FriendsEntity.builder()
                .userId(user)
                .friends(friend)
                .build();
        return friendsRepository.save(friendsEntity);
    }
}
