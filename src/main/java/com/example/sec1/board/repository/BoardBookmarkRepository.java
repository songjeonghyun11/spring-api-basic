package com.example.sec1.board.repository;

import com.example.sec1.board.entity.BoardBookmark;
import com.example.sec1.board.entity.BoardScrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardBookmarkRepository extends JpaRepository<BoardBookmark, Long> {
}
