package com.example.community.post.converter;


import com.example.community.post.domain.Post;
import com.example.community.post.dto.request.PostCreateRequestDto;
import com.example.community.post.dto.response.PostResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    public static Post toPost(PostCreateRequestDto dto) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return post;
    }

    // Entity → 응답 DTO
    public PostResponseDto toResponseDto(Post post) {
        return new PostResponseDto(post.getPostId(), post.getTitle(), post.getContent());
    }



    
}
