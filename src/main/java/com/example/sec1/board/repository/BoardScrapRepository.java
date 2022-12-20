package com.example.sec1.board.repository;

import com.example.sec1.board.entity.BoardBadReport;
import com.example.sec1.board.entity.BoardScrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardScrapRepository extends JpaRepository<BoardScrap, Long> {
}
