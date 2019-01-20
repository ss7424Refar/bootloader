package com.ats.bootloader.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("/helloWorld8")
    public String helloWorld2() {
        return "hello world2";
    }

}
