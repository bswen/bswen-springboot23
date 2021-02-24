package com.bswen.app9.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello2")
    public @ResponseBody String hello2(Authentication authentication) {
        return String.format("hello2 %s", authentication.getName());
    }

    @GetMapping("/hello")
    public String hello(Authentication authentication) {
        return "hello";
    }
}
