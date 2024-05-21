package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.request.BoardRequest;
import com.example.devops.domain.response.BoardResponse;

import java.util.List;

public interface BoardService {
    List<BoardResponse> getAll();
    void createBoard(BoardRequest req);
    BoardResponse getById(Long id);
    List<BoardResponse> getBoards();
    void deleteById(Long id);
}
