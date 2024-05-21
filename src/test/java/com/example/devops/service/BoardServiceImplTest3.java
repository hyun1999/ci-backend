package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.repository.BoardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BoardServiceImplTest3 {

    @InjectMocks private BoardServiceImpl boardService;
    @Mock private BoardRepository boardRepository;

    @Test
    void deleteByIdTest(){
//        case 1: id 가 있을 때
        Long id = 1L;
        BDDMockito.doNothing().when(boardRepository).deleteById(id); // 반환값이 없으면 아무일이 일어나지 않는다
        BDDMockito.given(boardRepository.findById(id)).willReturn(Optional.of(new Board(1L,null,null)));

//        when
        boardService.deleteById(id);
//        then
    }

    @Test
    void deleteByIdFail(){
//        case 2: id 가 없을 때
        Long id = 50000L;
        BDDMockito.given(boardRepository.findById(id)).willReturn(Optional.empty());

//        when & then
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            boardService.deleteById(id);
        });
    }
}
