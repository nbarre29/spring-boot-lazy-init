package com.naveen.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lazy")
public class LazyController {

//    @Lazy
    @Autowired  //3
    LazyService lazyService;

    @GetMapping  //4
    public String hello() {
        return lazyService.hello();
    }
}
