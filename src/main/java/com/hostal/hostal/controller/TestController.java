package com.hostal.hostal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Api is working";
    }


    @GetMapping("/hello")
    public String test(){
        return "Hello";
    }
}
