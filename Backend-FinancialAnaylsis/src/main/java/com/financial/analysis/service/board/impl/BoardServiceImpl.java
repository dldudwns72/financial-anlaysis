package com.financial.analysis.service.board.impl;

import com.financial.analysis.model.request.BoardRequest;
import com.financial.analysis.model.request.CommentRequest;
import com.financial.analysis.model.response.board.BoardResponse;
import com.financial.analysis.persistence.entity.board.BoardEntity;
import com.financial.analysis.persistence.entity.board.CommentEntity;
import com.financial.analysis.persistence.repository.BoardRepository;
import com.financial.analysis.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public BoardResponse createBoard(BoardRequest boardRequest) {

        BoardEntity boardEntity = BoardEntity.builder()
                .title(boardRequest.getTitle())
                .content(boardRequest.getContent())
                .register(boardRequest.getRegister())
                .build();

        BoardEntity savedBoard = boardRepository.save(boardEntity);

        BoardResponse boardResponse = BoardResponse.builder()
                .title(savedBoard.getTitle())
                .content(savedBoard.getContent())
                .register(savedBoard.getRegister())
                .build();

        return boardResponse;
    }

    @Override
    public BoardResponse getBoard(Long boardId) {
        return null;
    }

    @Override
    public List<BoardResponse> getBoards() {
        return null;
    }

    @Override
    public void updateBoard(BoardRequest boardRequest) {

    }

    @Override
    public void deleteBoard(Long boardId) {

    }
}
