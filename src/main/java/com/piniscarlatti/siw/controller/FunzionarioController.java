package com.piniscarlatti.siw.controller;

import com.piniscarlatti.siw.service.OrdiniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funzionario")
public class FunzionarioController {

    @Autowired
    private OrdiniService ordiniService;

    @GetMapping
    public String getFunzionario(Model model){
        model.addAttribute("ordini", ordiniService.getAll());
        return "funzionario";
    }

    @GetMapping("/{id}/fotografie")
    public String getFotografieOrdine(@PathVariable("id")Long id, Model model){
        model.addAttribute("fotografie", ordiniService.getFotoOrdine(id));
        return "listaFotografie";
    }

}
