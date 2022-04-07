package com.financial.analysis.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequest {

    private Long boardId;

    private String title;

    private String content;

    private Integer viewCount;

    private String register;

    private String modifier;

    private List<CommentRequest> comments = new ArrayList<>();

}
