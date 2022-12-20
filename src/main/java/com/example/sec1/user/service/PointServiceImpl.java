package com.example.sec1.user.service;

import com.example.sec1.board.model.ServiceResult;
import com.example.sec1.common.exception.BizException;
import com.example.sec1.user.entity.User;
import com.example.sec1.user.entity.UserPoint;
import com.example.sec1.user.model.UserPointInput;
import com.example.sec1.user.model.UserPointType;
import com.example.sec1.user.repository.UserPointRepository;
import com.example.sec1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PointServiceImpl implements PointService{

    private final UserPointRepository userPointRepository;
    private final UserRepository userRepository;

    @Override
    public ServiceResult addPoint(String email, UserPointInput userPointInput) {

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            throw new BizException("회원 정보가 존재하지 않습니다.");
        }
        User user = optionalUser.get();

        userPointRepository.save(UserPoint.builder()
                .user(user)
                .userPointType(userPointInput.getUserPointType())
                .point(userPointInput.getUserPointType().getValue())
                .build());

        return ServiceResult.success();
    }
}
