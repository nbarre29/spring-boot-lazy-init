package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    public List<String> getAllBooks() {
        return Arrays.asList("Book 1", "Book 2", "Book 3");
    }

    @GetMapping("/count")
    public int getBookCount() {
        return 3;
    }
}
