package com.example.sec1.board.entity;

import com.example.sec1.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class BoardScrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private User user;

    //스크랩글 정보
    @Column private long boardId;
    @Column private long boardTypeId;
    @Column private long boardUserId;
    @Column private String boardTitle;
    @Column private String boardContents;
    @Column private LocalDateTime boardRegDate;

    @Column private String comments;
    @Column private LocalDateTime regDate;
}
