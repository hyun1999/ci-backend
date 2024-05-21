package com.example.devops.controller;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.request.BoardRequest;
import com.example.devops.domain.response.BoardResponse;
import com.example.devops.service.BoardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BoardControllerTest {

    @Mock private BoardService boardService;
    @InjectMocks private BoardController boardController;


    @Test
    void createBoard() {
//        BoardRequest request = new BoardRequest("test","test");
//        BDDMockito.given(boardService.createBoard(request)).will()

    }

    @Test
    void getBoard() {
        BDDMockito.given(boardService.getBoards())
                .willReturn(List.of(
                        new BoardResponse(1L,"test","test"),
                        new BoardResponse(2L,"test2","test2")));

        List<BoardResponse> all = boardController.getBoard();

        assertEquals(2,all.size());
        assertEquals("test",all.get(0).name());
        Mockito.verify(boardService).getBoards();

    }
}