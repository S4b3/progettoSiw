package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.repository.FotografoRepository;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.PreUpdate;
import java.io.Console;
import java.security.Principal;

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

    @RequestMapping("user")
    @ResponseBody
    public Principal user(Principal principal)
    {
        return principal;
    }


}
