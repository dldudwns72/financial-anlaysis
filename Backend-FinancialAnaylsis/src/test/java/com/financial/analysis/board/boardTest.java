package com.financial.analysis.board;

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
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class boardTest {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CommentRepository commentRepository;

    BoardEntity boardEntity = null;
    CommentEntity comment1= null;
    CommentEntity comment2= null;

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
                .comments(Arrays.asList(comment1,comment2))
                .build();
    }

    @Test
    @DisplayName("게시판 생성")
    @Transactional
    void createBoard() {
        commentRepository.save(comment1);
        commentRepository.save(comment2);

        BoardEntity savedEntity = boardRepository.save(boardEntity);

        assertThat(savedEntity.getBoardId()).isEqualTo(1L);
        assertThat(savedEntity.getRegister().equals("Register")).isTrue();

        assertThat(savedEntity.getComments().get(0).getComment().equals("comment1")).isTrue();
        assertThat(savedEntity.getComments().get(1).getComment().equals("comment2")).isTrue();
    }
}
