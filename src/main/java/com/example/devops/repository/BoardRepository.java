package com.example.devops.repository;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.request.BoardRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
