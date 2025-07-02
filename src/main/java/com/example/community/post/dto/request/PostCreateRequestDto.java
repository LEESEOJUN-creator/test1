package com.example.community.post.dto.request;

import com.example.community.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostCreateRequestDto {
    private String title;
    private String content;
}
