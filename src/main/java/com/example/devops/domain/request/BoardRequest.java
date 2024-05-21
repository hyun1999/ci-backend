package com.example.devops.domain.request;

import com.example.devops.domain.entity.Board;

public record BoardRequest (String name, String text){
    public Board toEntity(){
        return Board.builder()
                .userId(null)
                .name(name)
                .text(text)
                .build();
    }
}
