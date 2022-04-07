package com.financial.analysis.model.response.board;

import com.financial.analysis.model.request.CommentRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class BoardResponse {
    private Long boardId;

    private String title;

    private Integer viewCount;

    private String register;

    private String modifier;

    private LocalDate createdDate;

    private LocalDate modifiedDate;

    private List<CommentRequest> comments;

}
