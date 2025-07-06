package com.example.community.comment.controller;

import com.example.community.comment.domain.Comment;
import com.example.community.comment.dto.request.CommentCreateRequestDto;
import com.example.community.comment.dto.resonse.CommentResponseDto;
import com.example.community.comment.service.CommentService;
import com.example.community.post.dto.response.PostResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("{postId}")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentCreateRequestDto dto, @PathVariable Long postId) {
        CommentResponseDto responsedto= commentService.createComment(dto,postId);
        return ResponseEntity.status(HttpStatus.CREATED).body(responsedto);
    }
    @DeleteMapping("{postId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long postId) {
        commentService.deleteComment(postId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // build는 응답만 반환

    }


}
