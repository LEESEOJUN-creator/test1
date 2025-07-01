package com.example.community.post.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseDto {
    private String title;
    private String content;
    private Long id;
}
