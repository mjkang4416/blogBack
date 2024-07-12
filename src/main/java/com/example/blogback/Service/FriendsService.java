package com.example.blogback.Service;

import com.example.blogback.dto.accounts.MyPageDTO;
import com.example.blogback.dto.friends.FriendPageDTO;
import com.example.blogback.entity.BookLogEntity;
import com.example.blogback.entity.FriendsEntity;
import com.example.blogback.entity.UserEntity;
import com.example.blogback.repository.BookLogRepository;
import com.example.blogback.repository.FriendsRepository;
import com.example.blogback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendsService {
    private final FriendsRepository friendsRepository;
    private final UserRepository userRepository;
    private final BookLogRepository bookLogRepository;
    private final BookLogService bookLogService;


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

    public FriendPageDTO getFriendPage(Long userId) {
        UserEntity userEntity = getFriendByUserId(userId);

        List<BookLogEntity> bookLogEntities;
        bookLogEntities = bookLogService.getBookLog(userId);

        return FriendPageDTO.builder()
                .userId(userEntity.getUserId())
                .nickname(userEntity.getNickname())
                .email(userEntity.getEmail())
                .img_url(userEntity.getImg_url())
                .intro(userEntity.getIntro())
                .bookLogs(bookLogEntities)
                .build();
    }
    public List<BookLogEntity> getFriendsBookLogs(@AuthenticationPrincipal UserEntity userId) {
        List<FriendsEntity> friendsList = friendsRepository.findByUserId(userId);

        List<UserEntity> friendsUserIds = friendsList.stream()
                .map(FriendsEntity::getFriends)
                .toList();

        return friendsUserIds.stream()
                .flatMap(friend -> bookLogRepository.findByUserId(friend).stream())
                .toList();
    }
    public UserEntity getFriendByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }
}
