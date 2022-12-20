package com.example.sec1.common.model;

import com.example.sec1.board.entity.BoardBadReport;
import com.example.sec1.board.model.ServiceResult;
import com.example.sec1.user.model.ResponseMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseResult {

    public static ResponseEntity<?> fail(String message) {
        return ResponseEntity.badRequest().body(ResponseMessage.fail(message));
    }

    public static ResponseEntity<?> success() {
        return success(null);
    }

    public static ResponseEntity<?> success(Object data) {
        return ResponseEntity.ok().body(ResponseMessage.success(data));
    }

        public static ResponseEntity<?> result(ServiceResult result) {
        if (result.isFail()) {
            return ResponseResult.fail(result.getMessage());
        }
        return success();
    }
}
