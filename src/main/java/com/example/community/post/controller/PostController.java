package com.example.community.post.controller;

import com.example.community.post.domain.Post;
import com.example.community.post.dto.request.PostCreateRequestDto;
import com.example.community.post.dto.request.PostUpdateRequestDto;
import com.example.community.post.dto.response.PostResponseDto;
import com.example.community.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping()
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostCreateRequestDto dto) {
        PostResponseDto responsedto = postService.createPost(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responsedto); //body는 내용을 담아서 보낸다
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // build는 응답만 반환
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable Long postId,@RequestBody PostUpdateRequestDto dto){

        PostResponseDto responsedto = postService.updatePost(postId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(responsedto);
    }
    @GetMapping()
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        List<PostResponseDto> responsedto=postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(responsedto);

    }
    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long postId) {
        PostResponseDto responsedto=postService.getPost(postId);
        return ResponseEntity.status(HttpStatus.OK).body(responsedto);
    }

}
