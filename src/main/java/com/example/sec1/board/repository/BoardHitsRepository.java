package com.example.sec1.board.repository;

import com.example.sec1.board.entity.Board;
import com.example.sec1.board.entity.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    long countByBoardType(BoardType boardType);
}
