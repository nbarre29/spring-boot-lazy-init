package com.example.client.service;

import com.example.client.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PostService {

    private final WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

    public List<Post> getAllPosts() {
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(Post.class)
                .collectList()
                .block();  // Blocking to return a synchronous response
    }
}
