package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.repository.FotografoRepository;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Console;

@Controller
public class ProjectController {

    @Autowired
    FotografoRepository fotografoRepository;

    @Autowired
    FunzionarioRepository fr;

    @Autowired
    PasswordEncoder pwd;


    @GetMapping("/home")
    public String getHome(){
        return "home";
    }


}
