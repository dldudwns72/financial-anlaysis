package com.financial.analysis.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    private String comment;

    private Integer likeCount =0;

    private Integer dislikeCount = 0;


}
