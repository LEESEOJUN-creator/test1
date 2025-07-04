package com.example.community.comment.dto.resonse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentResponseDto {

    private String content;
    private Long commentId;

    public CommentResponseDto(Long commentId, String content) {
        this.commentId = commentId;
        this.content = content;
    }

}
