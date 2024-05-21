package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.request.BoardRequest;
import com.example.devops.domain.response.BoardResponse;

import java.util.List;

public interface BoardService {
    void createBoard(BoardRequest req);

    List<BoardResponse> getBoards();
}
