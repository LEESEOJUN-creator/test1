package com.example.community.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostResponseDto {
    private String title;
    private String content;
    private Long id;


    public PostResponseDto(Long postId, String title, String content) {
        this.title = title;
        this.content = content;
        this.id = postId;
    }
}
