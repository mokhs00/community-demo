package com.example.communitydemo.service;

import com.example.communitydemo.domain.Board;
import com.example.communitydemo.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return this.boardRepository.findAll(pageable);
    }

    public Board findBoardById(Long id){
        return this.boardRepository.findById(id).orElse(new Board());
    }

}
