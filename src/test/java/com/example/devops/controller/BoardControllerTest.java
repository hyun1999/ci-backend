package com.example.devops.controller;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.request.BoardRequest;
import com.example.devops.domain.response.BoardResponse;
import com.example.devops.service.BoardService;
import com.example.devops.service.BoardServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(BoardController.class)
class BoardControllerTest {
    @MockBean
    private BoardServiceImpl boardService;
    // 인터페이스를 쓰면 생성하지 못하기 때문에 impl을 사용한다.
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllBoardTest() throws Exception {
//        given
//        boardService.getAll() 하면 list 3개를 던져줌
//        BDD
//        Monolithic 하나로 묶어서 개발하는 것
//        MSA 서비스 단위로 나눠서 개발하는 것
        BDDMockito.given(boardService.getBoards())
                .willReturn(List.of(
                        new BoardResponse(1L,"test1","test1"),
                        new BoardResponse(2L,"test2","test2"),
                        new BoardResponse(3L,"test3","test3")));
//        when & then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/boards"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1)) // 검증
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
                .andExpect(MockMvcResultMatchers.status().isOk()) //필수로 해줘야함
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void createBoardTest() {
        BoardRequest request = new BoardRequest("test1", "test1");
        BDDMockito.doNothing()
                .when(boardService)
                .createBoard(request);
        ObjectMapper objectMapper = new ObjectMapper();

    }

    @Test
    void getBoard() {
    }

    @Test
    void getByIdBoard() throws Exception{

    }
    @Test
    void hashCodeTest(){
        Board board = new Board(1L, "test", "test");
        board.hashCode();
        board.toString();

    }
}