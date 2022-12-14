package com.example.sec1.notice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeInput {

    @NotBlank(message = "제목은 필수 항목입니다.")
    @Size(min = 10, max = 100, message = "제목은 10자 이상 100자 사이입니다.")
    private String title;

    @NotBlank(message = "내용은 필수 항목입니다.")
    @Size(min = 50, max = 1000, message = "내용은 50자 이상 1000자 사이입니다.")
    private String contents;
}
