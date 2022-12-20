package com.example.sec1.board.repository;

import com.example.sec1.board.entity.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardTypeRepository extends JpaRepository<BoardType, Long> {
    BoardType findByBoardName(String name);
}
