package com.example.sec1.user.service;

import com.example.sec1.board.model.ServiceResult;
import com.example.sec1.user.entity.User;
import com.example.sec1.user.model.UserLogCount;
import com.example.sec1.user.model.UserNoticeCount;
import com.example.sec1.user.model.UserSummary;

import java.util.List;

public interface UserService {

    UserSummary getUserStatusCount();

    List<User> getTodayUsers();

    List<UserNoticeCount> getUserNoticeCount();

    List<UserLogCount> getUserLogCount();

    List<UserLogCount> getUserLikeBest();

    ServiceResult addInterestUser(String email, Long id);

    ServiceResult removeInterestUser(String email, Long interestId);
}
