package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ControllerExample {
    @Value("${myapplication.mesaj}")
    private String testValue;

    @GetMapping("")
    public String test(){
        return testValue;
    }
}
