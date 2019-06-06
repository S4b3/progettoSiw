package com.piniscarlatti.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/photographers/{idP}/album/{idA}/photo")
public class FotoController {

    @GetMapping
    public String visualizzaFoto(){
        return "visualizzaFoto";
    }
}
