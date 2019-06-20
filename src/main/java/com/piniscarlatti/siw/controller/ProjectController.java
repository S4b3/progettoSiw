package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.repository.FotografoRepository;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import com.piniscarlatti.siw.service.CarrelloServiceImpl;
import com.piniscarlatti.siw.service.FotografoService;
import com.piniscarlatti.siw.service.FotografoServiceImpl;
import com.piniscarlatti.siw.service.FunzionarioServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.PreUpdate;
import java.io.Console;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class ProjectController {

    private FunzionarioServiceImpl funzionarioService;
    private FunzionarioRepository fr;
    private PasswordEncoder pwd;
    private CarrelloServiceImpl carrelloService;

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

    @GetMapping("/carrello")
    public String Carrello(Model model){
        model.addAttribute("fotografie",carrelloService.tutteLeFoto());
        model.addAttribute("carrello",funzionarioService.funzionarioCorrente().getCarrello());
        return "carrello";
    }


    @RequestMapping("user")
    @ResponseBody
    public Principal user(Principal principal)
    {
        return principal;
    }


}
