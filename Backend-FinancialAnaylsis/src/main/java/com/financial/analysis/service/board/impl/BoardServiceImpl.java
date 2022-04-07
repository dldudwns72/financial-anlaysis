package com.financial.analysis.service.board.impl;

import com.financial.analysis.model.request.BoardRequest;
import com.financial.analysis.model.response.board.BoardResponse;
import com.financial.analysis.service.board.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Override
    public void createBoard(BoardRequest boardRequest) {

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
