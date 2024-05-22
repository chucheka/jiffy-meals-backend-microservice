package com.chucheka.identityservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

    @Value("${app.secret}")
    private String secret;


    @GetMapping("/hello")
    public String helloworld() {
        System.out.println("***** THE SECRET " + secret);
        return "Hello World";
    }
}
