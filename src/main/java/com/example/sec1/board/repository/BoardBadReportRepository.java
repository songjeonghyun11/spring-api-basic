package com.example.sec1.board.repository;

import com.example.sec1.board.entity.Board;
import com.example.sec1.board.entity.BoardHits;
import com.example.sec1.board.entity.BoardType;
import com.example.sec1.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardHitsRepository extends JpaRepository<BoardHits, Long> {

    long countByBoardAndUser(Board board, User user);

}
