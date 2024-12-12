package com.cts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HomeController {

    @GetMapping("/")
    public String getRoot(){
        return "This is the root endpoint";
    }
    
    @GetMapping("/home")
    public String getHome(){
        return "This is the Home page";
    }
    
}
