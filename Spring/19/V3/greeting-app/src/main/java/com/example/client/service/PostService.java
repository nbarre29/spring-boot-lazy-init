package com.example.client.service;

import com.example.client.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final String API_URL = "https://jsonplaceholder.typicode.com/posts";

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Get all posts with pagination support
     */
    public List<Post> getAllPosts(int page, int size) {
        try {
            String url = API_URL + "?_page=" + page + "&_limit=" + size;
            logger.info("Fetching posts from: {}", url);
            
            ResponseEntity<Post[]> response = restTemplate.getForEntity(url, Post[].class);

            if (response.getBody() != null) {
                return Arrays.asList(response.getBody());
            } else {
                return Collections.emptyList();
            }
        } catch (RestClientException e) {
            logger.error("Error fetching posts: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Get a specific post by ID
     */
    public Post getPostById(int postId) {
        try {
            String url = API_URL + "/" + postId;
            logger.info("Fetching post with ID: {}", postId);
            return restTemplate.getForObject(url, Post.class);
        } catch (RestClientException e) {
            logger.error("Error fetching post with ID {}: {}", postId, e.getMessage());
            return null;
        }
    }

    /**
     * Create a new post
     */
    public Post createPost(Post post) {
        try {
            logger.info("Creating a new post: {}", post);
            return restTemplate.postForObject(API_URL, post, Post.class);
        } catch (RestClientException e) {
            logger.error("Error creating post: {}", e.getMessage());
            return null;
        }
    }

    /**
     * Delete a post by ID
     */
    public boolean deletePost(int postId) {
        try {
            String url = API_URL + "/" + postId;
            logger.info("Deleting post with ID: {}", postId);
            restTemplate.delete(url);
            return true;
        } catch (RestClientException e) {
            logger.error("Error deleting post with ID {}: {}", postId, e.getMessage());
            return false;
        }
    }
}
