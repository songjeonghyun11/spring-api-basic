package com.example.sec1.notice.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeModel {

    //ID, 제목, 내용, 등록일
    private int id;
    private String title;
    private String contents;
    private LocalDateTime regDate;
}
