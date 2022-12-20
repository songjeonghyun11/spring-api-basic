package com.example.sec1.user.repository;

import com.example.sec1.user.entity.User;
import com.example.sec1.user.entity.UserInterest;
import com.example.sec1.user.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserInterestRepository extends JpaRepository<UserInterest, Long> {

    long countByUserAndAndInterestUser(User user, User interestUser);

}

