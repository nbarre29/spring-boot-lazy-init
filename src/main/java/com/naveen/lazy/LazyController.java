package com.naveen.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lazy")
public class LazyController {

//    @Lazy
    @Autowired  //new main commentsss
    LazyService lazyService;

    @GetMapping  //initial_abcn
    public String hello() {
        return lazyService.hello(); 
    }
}
