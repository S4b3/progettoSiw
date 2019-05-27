package com.piniscarlatti.siw.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.piniscarlatti.siw.entity.Fotografo;
import com.piniscarlatti.siw.repository.FotografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Console;

@Controller
public class ProjectController {

    @Autowired
    FotografoRepository fotografoRepository;

    @GetMapping("/home")
    public String getHome(){
        fotografoRepository.save(new Fotografo("Sto", "cazzo", "alfa1@gmail.com"));
        return "home";
    }

}
