package com.example.community.comment.service;

import com.example.community.comment.dto.request.CommentCreateRequestDto;
import com.example.community.comment.dto.resonse.CommentResponseDto;
import com.example.community.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;


    public CommentResponseDto createComment(CommentCreateRequestDto dto, Long postId) {
    }
}
