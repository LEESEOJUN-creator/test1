package com.example.community.post.service;

import com.example.community.post.converter.PostConverter;
import com.example.community.post.domain.Post;
import com.example.community.post.dto.request.PostCreateRequestDto;
import com.example.community.post.dto.request.PostUpdateRequestDto;
import com.example.community.post.dto.response.PostResponseDto;
import com.example.community.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostConverter postConverter;

    public PostResponseDto createPost(PostCreateRequestDto dto) {
        Post post = PostConverter.toPost(dto);
        Post saved = postRepository.save(post);
        return postConverter.toResponseDto(saved);
    }
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("post not found")); // id를 못찾으면 exception던짐
        postRepository.delete(post);
    }
    public PostUpdateRequestDto updatePost(Long postId, PostUpdateRequestDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("post not found"));
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return dto;
    }
}
