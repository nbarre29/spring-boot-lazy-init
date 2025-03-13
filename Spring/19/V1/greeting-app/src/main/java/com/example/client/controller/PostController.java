package com.example.client.controller;

import com.example.client.model.Post;
import com.example.client.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> fetchPosts() {
        return postService.getAllPosts();
    }
}
