package com.example.devops.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Builder @Getter @Table(name = "USERS")
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TEXT")
    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(getUserId(), board.getUserId()) && Objects.equals(getName(), board.getName()) && Objects.equals(getText(), board.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getName(), getText());
    }
}
