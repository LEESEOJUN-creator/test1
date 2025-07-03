package com.example.community.post.domain;

import com.example.community.post.dto.request.PostUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    private String title;

    private String content;



public void update(PostUpdateRequestDto dto) {
    this.title = dto.getTitle();
    this.content = dto.getContent();
}


}
