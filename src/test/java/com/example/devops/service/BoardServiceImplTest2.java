package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.repository.BoardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //spring bean객체들을 사용할 수 있음
public class BoardServiceImplTest2 {
    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;
    @Test
    void deleteById(){
//        case 1: id 가 있을 때
//        given boardService.deleteById(???);
        Board save = boardRepository.save(new Board(null, "test", "test"));
        Long id = save.getUserId();
//        when
        boardService.deleteById(id);
//        then
        Assertions.assertEquals(0,boardRepository.findAll().size());
    }

    @Test
    void deleteByIdFail(){
//        case 2: id 가 없을 때
//        given boardService.deleteById();
        Long id = 80000L;
//        when & then 실행 시키자마자 에러가 뜨기 때문에 when then 통합
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            boardService.deleteById(id);
        });
    }
}
