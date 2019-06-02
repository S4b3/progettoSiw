package com.piniscarlatti.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funzionario")
public class FunzionarioController {

    @GetMapping
    public String getFunzionario(){
        return "funzionario";
    }
}
