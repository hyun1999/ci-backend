package com.example.devops.domain.response;

import com.example.devops.domain.entity.Board;

public record BoardResponse(Long id,String name, String text) {
    public static BoardResponse from(Board board){
        return new BoardResponse(
                board.getUserId(),
                board.getName(),
                board.getText()
        );
    }
}
