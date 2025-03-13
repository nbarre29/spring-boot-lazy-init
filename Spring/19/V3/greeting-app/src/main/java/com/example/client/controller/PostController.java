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

    /**
     * Get all posts with pagination
     */
    @GetMapping
    public List<Post> fetchPosts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        return postService.getAllPosts(page, size);
    }

    /**
     * Get a single post by ID
     */
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    /**
     * Create a new post
     */
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    /**
     * Delete a post by ID
     */
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable int id) {
        return postService.deletePost(id) ? "Post deleted successfully!" : "Failed to delete post.";
    }
}
