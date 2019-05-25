package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.model.Fotografo;
import com.piniscarlatti.siw.repository.FotografoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    @Autowired
    FotografoRepository fotografoRepository;

    @GetMapping("/home")
    public String getHome(){
        fotografoRepository.save(new Fotografo("giulia","cattaneo","alfa@gmail.com"));
        return "home";
    }

}
