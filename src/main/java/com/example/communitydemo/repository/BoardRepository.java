package com.example.communitydemo.repository;

import com.example.communitydemo.domain.Board;
import com.example.communitydemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
