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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    void getAllBoard(){

    }
    @Test
    void getByIdBoard() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/boards/1"))
                .andExpect(MockMvcResultMatchers.status().is5xxServerError());
    }
    @Test
    void createBoard() {

    }

    @Test
    void getBoard() {
    }
    @Test
    void hashCodeTest(){
        Board board = new Board(1L, "test", "test");
        board.hashCode();
        board.toString();

    }
}