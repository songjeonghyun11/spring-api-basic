package com.example.sec1.user.controller;


import com.example.sec1.notice.repository.NoticeRepository;
import com.example.sec1.user.entity.User;
import com.example.sec1.user.entity.UserLoginHistory;
import com.example.sec1.user.model.*;
import com.example.sec1.user.repository.UserLoginHistoryRepository;
import com.example.sec1.user.repository.UserRepository;
import com.example.sec1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ApiAdminUserController {

    private final UserRepository userRepository;
    private final NoticeRepository noticeRepository;
    private final UserLoginHistoryRepository userLoginHistoryRepository;
    private final UserService userService;

    //48
    /*@GetMapping("/api/admin/user")
    public ResponseMessage userList() {

        List<User> userList = userRepository.findAll();
        long totalUserCount = userRepository.count();

        return ResponseMessage.builder()
                .totalCount(totalUserCount)
                .data(userList)
                .build();
    }*/

    //49
    @GetMapping("/api/admin/user/{id}")
    public ResponseEntity<?> userDetail(@PathVariable Long id) {

        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            return new ResponseEntity<>(ResponseMessage.fail("사용자 정보가 존재하지 않습니다."), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(ResponseMessage.success(user));
    }

    //50
    @GetMapping("/api/admin/user/search")
    public ResponseEntity<?> findUser(@RequestBody UserSearch userSearch) {

        List<User> userList = userRepository.findByEmailContainsOrPhoneContainsOrUserNameContains(userSearch.getEmail(),
                userSearch.getPhone(), userSearch.getUserName());

        return ResponseEntity.ok().body(ResponseMessage.success(userList));
    }

    //51 - 사용자의 상태를 변경
    @PatchMapping("/api/admin/user/{id}/status")
    public ResponseEntity<?> userStatus(@PathVariable Long id, @RequestBody UserStatusInput userStatusInput) {

        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            return new ResponseEntity<>(ResponseMessage.fail("사용자 정보가 존재하지 않습니다."), HttpStatus.BAD_REQUEST);
        }
        User user = optionalUser.get();

        user.setStatus(userStatusInput.getStatus());
        userRepository.save(user);

        return ResponseEntity.ok().build();
    }

    //52 - 사용자 정보 삭제
    @DeleteMapping("/api/admin/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            return new ResponseEntity<>(ResponseMessage.fail("사용자 정보가 존재하지 않습니다."), HttpStatus.BAD_REQUEST);
        }
        User user = optionalUser.get();

        if (noticeRepository.countByUser(user) > 0) {
            return new ResponseEntity<>(ResponseMessage.fail("사용자가 작성한 공지사항이 있습니다."), HttpStatus.BAD_REQUEST);
        }

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

    //53 - ## 사용자가 로그인을 했을때 이에 대한 접속 이력이 저장된다고 했을 때,  접속이력을 조회하는 API
    @GetMapping("/api/admin/user/login/history")
    public ResponseEntity<?> userLoginHistory() {

        List<UserLoginHistory> userLoginHistory = userLoginHistoryRepository.findAll();

        return ResponseEntity.ok().body(userLoginHistory);
    }
    //54 - 사용자의 접속 제한
    @PatchMapping("/api/admin/user/{id}/lock")
    public ResponseEntity<?> userLock(@PathVariable Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            return new ResponseEntity<>(ResponseMessage.fail("사용자 정보가 존재하지 않습니다."), HttpStatus.BAD_REQUEST);
        }

        User user = optionalUser.get();

        if(user.isLockYn()) {
            return new ResponseEntity<>(ResponseMessage.fail("이미 접속제한이 된 사용자 입니다."), HttpStatus.BAD_REQUEST);
        }
        user.setLockYn(true);
        userRepository.save(user);

        return ResponseEntity.ok().body(ResponseMessage.success());
    }

    //55-유저 언락
    @PatchMapping("/api/admin/user/{id}/unlock")
    public ResponseEntity<?> userUnLock(@PathVariable Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            return new ResponseEntity<>(ResponseMessage.fail("사용자 정보가 존재하지 않습니다."), HttpStatus.BAD_REQUEST);
        }

        User user = optionalUser.get();

        if(!user.isLockYn()) {
            return new ResponseEntity<>(ResponseMessage.fail("이미 접속제한이 해제된 사용자 입니다."), HttpStatus.BAD_REQUEST);
        }
        user.setLockYn(false);
        userRepository.save(user);

        return ResponseEntity.ok().body(ResponseMessage.success());
    }

    //56
    @GetMapping("/api/admin/user/status/count")
    public ResponseEntity<?> userStatusCount() {

        UserSummary userSummary = userService.getUserStatusCount();

        return ResponseEntity.ok().body(ResponseMessage.success(userSummary));

    }

    //57-금일 가입자
    @GetMapping("/api/admin/user/today")
    public ResponseEntity<?> todayUser() {

        List<User> users = userService.getTodayUsers();

        return ResponseEntity.ok().body(ResponseMessage.success(users));
    }

    //58-사용자별 게시글 수
    @GetMapping("/api/admin/user/notice/count")
    public ResponseEntity<?> userNoticeCount() {

        List<UserNoticeCount> userNoticeCountList = userService.getUserNoticeCount();

        return ResponseEntity.ok().body(ResponseMessage.success(userNoticeCountList));
    }

    //59
    @GetMapping("/api/admin/user/log/count")
    public ResponseEntity<?> userLogCount() {

        List<UserLogCount> userLogCounts = userService.getUserLogCount();

        return ResponseEntity.ok().body(ResponseMessage.success(userLogCounts));
    }

    //60
    @GetMapping("/api/admin/user/like/best")
    public ResponseEntity<ResponseMessage> bestLikeCount() {

        List<UserLogCount> userLogCounts = userService.getUserLikeBest();

        return ResponseEntity.ok().body(ResponseMessage.success(userLogCounts));

    }
}

