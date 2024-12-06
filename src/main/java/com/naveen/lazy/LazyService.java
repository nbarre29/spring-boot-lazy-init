package com.naveen.lazy;

import org.springframework.stereotype.Service;

// service class naveen_1
// service class main_1
@Service
public class LazyService {

    public LazyService() {
        System.out.println("Lazy Service:: Constructor loaded");
    }

    public String hello() {
        return "hello youtube";
    }
}
