package com.hostal.hostal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/welcome")
    public String welcome(){
        return "WELCOME TO HOSTEL";
    }

    @GetMapping("/hello")
    public String test(){
        return "Hello";
    }
}
