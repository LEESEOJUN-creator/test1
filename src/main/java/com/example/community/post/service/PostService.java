package com.example.community.post.service;

import com.example.community.post.domain.Post;
import com.example.community.post.dto.request.PostCreateRequestDto;
import com.example.community.post.dto.request.PostUpdateRequestDto;
import com.example.community.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostCreateRequestDto createPost(PostCreateRequestDto dto) {
        Post post = dto.toEntity();
        Post saved = postRepository.save(post);
        postRepository.save(post);
        return  dto;
    }
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("post not found"));
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
