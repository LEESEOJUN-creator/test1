package com.example.community.comment.converter;

import com.example.community.comment.domain.Comment;
import com.example.community.comment.dto.request.CommentCreateRequestDto;
import com.example.community.comment.dto.resonse.CommentResponseDto;
import com.example.community.post.domain.Post;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    public static Comment toComment(CommentCreateRequestDto dto) {
        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        return comment;
    }
    public CommentResponseDto toResponseDto(Comment comment) {
        return new CommentResponseDto(comment.getCommentId(),comment.getContent());
    }
}

