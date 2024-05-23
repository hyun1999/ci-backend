package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.request.BoardRequest;
import com.example.devops.domain.response.BoardResponse;
import com.example.devops.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public List<BoardResponse> getAll() {
        return null;
    }

    @Override
    public void createBoard(BoardRequest req) {
        boardRepository.save(req.toEntity());
    }

    @Override
    public BoardResponse getById(Long id) {
        return null;
    }

    @Override
    public List<BoardResponse> getBoards() {
        List<Board> all = boardRepository.findAll();
        return all.stream().map(BoardResponse::from).toList();
    }

    @Override
    public void deleteById(Long id) {
        Optional<Board> byId = boardRepository.findById(id);
        byId.orElseThrow(IllegalArgumentException::new);
        boardRepository.deleteById(id);

    }


    public BoardResponse getById(long id) {
        Board board = boardRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return BoardResponse.from(board);
    }
}
