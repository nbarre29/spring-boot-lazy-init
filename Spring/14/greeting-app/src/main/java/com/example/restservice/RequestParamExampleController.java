package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RequestParamExampleController {

    @GetMapping("/search")
    public String searchUser(@RequestParam("name") String name,
                             @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        return "Searching for user: " + name + ", Age: " + age;
    }
}
