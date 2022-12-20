package com.example.sec1.board.repository;

import com.example.sec1.board.entity.BoardBadReport;
import com.example.sec1.board.entity.BoardComment;
import com.example.sec1.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {
    List<BoardComment> findByUser(User user);
}
