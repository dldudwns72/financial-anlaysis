package com.financial.analysis.service.board;

import com.financial.analysis.model.request.BoardRequest;
import com.financial.analysis.model.response.board.BoardResponse;

import java.util.List;

public interface BoardService {

    void createBoard(BoardRequest boardRequest);

    BoardResponse getBoard(Long boardId);

    List<BoardResponse> getBoards();

    void updateBoard(BoardRequest boardRequest);

    void deleteBoard(Long boardId);
}
