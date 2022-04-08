package com.financial.analysis.persistence.repository.board;

import com.financial.analysis.persistence.entity.board.BoardEntity;
import com.financial.analysis.persistence.entity.board.CommentEntity;
import com.financial.analysis.persistence.repository.BoardRepository;
import com.financial.analysis.persistence.repository.CommentRepository;
import com.financial.analysis.service.board.BoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class boardTest {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CommentRepository commentRepository;

    BoardEntity boardEntity = null;
    CommentEntity comment1 = null;
    CommentEntity comment2 = null;

    @BeforeEach
    void setUp() {
        comment1 = CommentEntity.builder()
                .comment("comment1").build();

        comment2 = CommentEntity.builder()
                .comment("comment2").build();

        boardEntity = BoardEntity.builder()
                .title("Title1")
                .content("Content1")
                .register("Register")
                .comments(Arrays.asList(comment1, comment2))
                .build();
    }

    @Test
    @DisplayName("게시판 생성")
    @Transactional
    void createBoard() {
        BoardEntity savedEntity = boardRepository.save(boardEntity);

        assertThat(savedEntity.getBoardId()).isEqualTo(1L);
        assertThat(savedEntity.getContent()).isEqualTo("Content1");
        assertThat(savedEntity.getRegister().equals("Register")).isTrue();
    }

    @Test
    @DisplayName("게시판 조회")
    @Transactional
    void getBoards() {
        commentRepository.save(comment1);
        commentRepository.save(comment2);
        boardEntity.setCreatedDate(LocalDateTime.now());
        boardRepository.save(boardEntity);

        List<BoardEntity> boards = boardRepository.findAll();

        assertThat(boards.size()).isEqualTo(1);
    }


    @Test
    @DisplayName("게시판 단일 조회")
    @Transactional
    void getBoardById() {
        commentRepository.save(comment1);
        commentRepository.save(comment2);

        boardRepository.save(boardEntity);

        // orElse는 값이 있던 없던 인수 값으로 반환한다.
        // 테스트를 orElseGet으로 해야할듯
        Optional<BoardEntity> board = boardRepository.findById(1L);

        assertThat(board.orElseGet(() -> new BoardEntity())).isEqualTo("Title1");
    }

    @Test
    @DisplayName("게시판 수정 및 댓글 추가")
    @Transactional
    void updateBoardAndComments(){
        //Transctional을 해도 Id는 자동으로 늘어난다. 왜일까 -> 생성 되었다가 rollback 되어서 ID 값이 증가 된 후 다시 삭제되서 ID값이 다시 이미 증가된 상태였다.
        commentRepository.save(comment1);
        commentRepository.save(comment2);
        boardRepository.save(boardEntity);

        BoardEntity foundBoard = boardRepository.findByTitle("Title1").get();
        System.out.println(foundBoard.getTitle());

    }

    @Test
    @DisplayName("게시판 DB 제거")
    @Transactional(rollbackOn = NoSuchElementException.class)
    void deleteBoard() {
        commentRepository.save(comment1);
        commentRepository.save(comment2);
        boardRepository.save(boardEntity);

        boardRepository.deleteById(1L);

        assertThatThrownBy(() ->{
            // get까지 선언 해주어야 Error 발생
            boardRepository.findById(1L).get();
        }).isInstanceOf(NoSuchElementException.class);
    }


}

