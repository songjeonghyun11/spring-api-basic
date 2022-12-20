package com.example.sec1.user.service;

import com.example.sec1.board.model.ServiceResult;
import com.example.sec1.user.model.UserPointInput;
import com.example.sec1.user.model.UserPointType;

public interface PointService {

    ServiceResult addPoint(String email, UserPointInput userPointInput);
}
