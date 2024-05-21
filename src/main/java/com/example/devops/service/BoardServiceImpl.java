package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.request.BoardRequest;
import com.example.devops.domain.response.BoardResponse;
import com.example.devops.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    @Override
    public void createBoard(BoardRequest req) {
        boardRepository.save(req.toEntity());
    }

    @Override
    public List<BoardResponse> getBoards() {
        List<Board> all = boardRepository.findAll();
        return all.stream().map(BoardResponse::from).toList();
    }

    public BoardResponse getById(long id) {
        Board board = boardRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return BoardResponse.from(board);
    }
}
