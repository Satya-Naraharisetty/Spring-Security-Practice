package com.springsec.springsecdemo.controller;

import jakarta.servlet.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        return "Welcome to the Spring Security Demo Application! Session ID: " + request.getSession().getId();
    }

    @GetMapping("hello")
    public String great(HttpServletRequest request) {
        return "Hello, World! " + request.getSession().getId();
    }

    @GetMapping("about")
    public String about(HttpServletRequest request) {
        return "About this application " + request.getSession().getId();
    }

    @GetMapping("contact")
    public String contact(HttpServletRequest request) {
        return "Contact us at admin@gmail.com";
    }
}
