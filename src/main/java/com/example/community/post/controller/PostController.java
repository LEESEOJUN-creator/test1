package com.example.community.post.controller;

import com.example.community.post.domain.Post;
import com.example.community.post.dto.request.PostCreateRequestDto;
import com.example.community.post.dto.request.PostUpdateRequestDto;
import com.example.community.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostCreateRequestDto> createPost(@RequestBody PostCreateRequestDto dto) {
        PostCreateRequestDto post = postService.createPost(dto);
        return  ResponseEntity.ok(post);
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<PostUpdateRequestDto> updatePost(@PathVariable Long postId,@RequestBody PostUpdateRequestDto dto){

        PostUpdateRequestDto responsedto =postService.updatePost(postId,dto);
        return  ResponseEntity.ok(responsedto);
    }
}
