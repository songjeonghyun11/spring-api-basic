package com.example.sec1.board.controller;

import com.example.sec1.board.entity.BoardBadReport;
import com.example.sec1.board.service.BoardService;
import com.example.sec1.common.model.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ApiAdminBoardController {

    private final BoardService boardService;

    //74-게시글 신고 목록
    @GetMapping("/api/admin/board/badreport")
    public ResponseEntity<?> badReport() {

        List<BoardBadReport> list = boardService.badReportList();
        return ResponseResult.success(list);
    }
}
