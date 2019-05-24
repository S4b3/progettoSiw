package com.piniscarlatti.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {


    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

}
