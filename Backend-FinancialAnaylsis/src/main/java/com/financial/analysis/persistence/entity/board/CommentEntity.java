package com.financial.analysis.persistence.entity.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "board_id")
    private Long boardId;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Builder
    public CommentEntity(String comment){
        this.comment = comment;
    }


}
