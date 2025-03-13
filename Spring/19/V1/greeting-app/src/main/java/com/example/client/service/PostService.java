package com.example.client.service;

import com.example.client.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private final String API_URL = "https://jsonplaceholder.typicode.com/posts";

    public List<Post> getAllPosts() {
        RestTemplate restTemplate = new RestTemplate();
        Post[] posts = restTemplate.getForObject(API_URL, Post[].class);
        return Arrays.asList(posts);
    }
}
