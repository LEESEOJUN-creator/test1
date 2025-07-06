package com.example.community.comment.service;

import com.example.community.comment.converter.CommentConverter;
import com.example.community.comment.domain.Comment;
import com.example.community.comment.dto.request.CommentCreateRequestDto;
import com.example.community.comment.dto.resonse.CommentResponseDto;
import com.example.community.comment.repository.CommentRepository;
import com.example.community.post.domain.Post;
import com.example.community.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentConverter commentConverter;


    public CommentResponseDto createComment(CommentCreateRequestDto dto, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("post not found"));
        Comment comment =CommentConverter.toComment(dto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return commentConverter.toResponseDto(savedComment);

    }

    public void deleteComment(Long postId) {

    }
}
