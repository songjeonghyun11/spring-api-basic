package com.example.sec1.user.controller;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.example.sec1.board.model.ServiceResult;
import com.example.sec1.common.model.ResponseResult;
import com.example.sec1.user.service.UserService;
import com.example.sec1.util.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ApiUserInterestController {

    private final UserService userService;

    //78-관심사용자 등록
    @PutMapping("/api/user/{id}/interest")
    public ResponseEntity<?> interestUser(@PathVariable Long id,
                             @RequestHeader("TOKEN") String token){

        String email = "";
        try {
            email = JWTUtils.getIssuer(token);
        } catch(SignatureVerificationException e) {
            return new ResponseEntity<>("토큰 정보가 정확하지 않습니다.", HttpStatus.BAD_REQUEST);
        }

        ServiceResult result = userService.addInterestUser(email, id);
        return ResponseResult.result(result);
    }

    //79-관심사용자 삭제
    @DeleteMapping("/api/user/interest/{id}")
    public ResponseEntity<?> deleteInterestUser(@PathVariable Long id,
                                          @RequestHeader("TOKEN") String token){

        String email = "";
        try {
            email = JWTUtils.getIssuer(token);
        } catch(SignatureVerificationException e) {
            return new ResponseEntity<>("토큰 정보가 정확하지 않습니다.", HttpStatus.BAD_REQUEST);
        }

        ServiceResult result = userService.removeInterestUser(email, id);
        return ResponseResult.result(result);
    }

}
