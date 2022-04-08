package com.financial.analysis.persistence.entity.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor
public class BoardEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "board_id")
    private Long boardId;

    @Column(columnDefinition = "VARCHAR(255)")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "INT")
    private Integer viewCount;

    @Column(columnDefinition = "VARCHAR(255)")
    private String register;

    @Column(columnDefinition = "VARCHAR(255)")
    private String modifier;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime modifiedDate;

    @OneToMany
    @JoinColumn(name = "board_id")
    private List<CommentEntity> comments = new ArrayList<>();

    @Builder
    public BoardEntity(String title, String content, String register,List<CommentEntity> comments){
        this.title = title;
        this.content =content;
        this.register = register;
        this.comments = comments;
    }

}
