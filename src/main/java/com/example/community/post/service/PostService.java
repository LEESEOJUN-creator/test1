package com.example.community.post.service;

import com.example.community.post.converter.PostConverter;
import com.example.community.post.domain.Post;
import com.example.community.post.dto.request.PostCreateRequestDto;
import com.example.community.post.dto.request.PostUpdateRequestDto;
import com.example.community.post.dto.response.PostResponseDto;
import com.example.community.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public PostResponseDto updatePost(Long postId, PostUpdateRequestDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("post not found"));
        post.update(dto);
        Post saved=postRepository.save(post);
        return postConverter.toResponseDto(saved);

    }
    public List<PostResponseDto> getAllPosts() {
        List<Post> posts= postRepository.findAll();
       PostResponseDto dtos;
        return posts.stream()
                .map(postConverter::toResponseDto)
                .collect(Collectors.toList());
    }
    public PostResponseDto getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("post not found"));
        return postConverter.toResponseDto(post);
    }


}
