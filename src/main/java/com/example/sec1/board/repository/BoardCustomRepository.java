package com.example.sec1.board.repository;

import com.example.sec1.board.entity.BoardType;
import com.example.sec1.board.model.BoardTypeCount;
import com.example.sec1.user.model.UserLogCount;
import com.example.sec1.user.model.UserNoticeCount;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class BoardCustomRepository {

    private final EntityManager entityManager;

    public List<BoardTypeCount> getBoardTypeCount() {

        String sql = " select bt.id, bt.board_name, bt.reg_date, bt.using_yn " +
                ", (select count(*) from board b where b.board_type_id = bt.id) as board_count " +
                "from board_type bt";

        //List<BoardTypeCount> list = entityManager.createNativeQuery(sql).getResultList();

      /*  List<Object[]> result = entityManager.createNativeQuery(sql).getResultList();
        List<BoardTypeCount> resultList = result.stream().map(e -> new BoardTypeCount(e))
                .collect(Collectors.toList());*/

        //좀더 간단하게 QLRM을 이용하여 사용
        Query nativeQuery = entityManager.createNativeQuery(sql);
        JpaResultMapper jpaResultMapper = new JpaResultMapper();
        List<BoardTypeCount> resultList = jpaResultMapper.list(nativeQuery,BoardTypeCount.class);

        return resultList;
    }
}

