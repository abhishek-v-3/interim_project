package com.cts.ClinicManagement.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


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
